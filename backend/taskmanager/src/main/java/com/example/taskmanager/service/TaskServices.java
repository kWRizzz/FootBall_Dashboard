package com.example.taskmanager.service;


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
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task Not Found"));
    }

    public Task updateTask(Long id , Task updatedTask){
        Task existingTask= taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot delete it"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task Not FOund"));
        taskRepository.delete(task);
    }

}
