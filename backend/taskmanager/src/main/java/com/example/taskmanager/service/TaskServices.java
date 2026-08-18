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
}
