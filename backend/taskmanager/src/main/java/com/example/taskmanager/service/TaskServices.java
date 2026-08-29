package com.example.taskmanager.service;


import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

//  Future dataBase inclusion pending
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public TaskServices(TaskRepository taskRepository , TaskMapper taskMapper){
        this.taskRepository=taskRepository;
        this.taskMapper=taskMapper;
    }

//    @POST creating task
    public TaskResponse createTask(TaskRequest request){

//        return taskRepository.save(task);

        Task task =new Task(
                request.getTitle(),
                request.isCompleted()
        );

        Task savedTask= taskRepository.save(task);

        return  taskMapper.toResponse(savedTask);
    }

    public List<TaskResponse> getAllTask(){
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    public TaskResponse gerTaskById(Long id){
        Task task =taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException("Task Not Found" + id));
        return taskMapper.toResponse(task);
    }

    public TaskResponse updateTask(Long id , Task updatedTask){
        Task existingTask= taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException("Cannot delete it" + id ));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());

        Task updatedTasks=taskRepository.save(existingTask);

//        return taskRepository.save(existingTask);
        return  taskMapper.toResponse(updatedTasks);
        }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task Not FOund" + id));
        taskRepository.delete(task);
    }


    
}
