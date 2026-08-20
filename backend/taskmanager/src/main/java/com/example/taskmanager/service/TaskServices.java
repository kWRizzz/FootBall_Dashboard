package com.example.taskmanager.service;


import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

//  Future dataBase inclusion pending
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

//    @POST creating task
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task gerTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task Not Found" + id));
    }

    public Task updateTask(Long id , Task updatedTask){
        Task existingTask= taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Cannot delete it" + id ));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task Not FOund" + id));
        taskRepository.delete(task);
    }

}
