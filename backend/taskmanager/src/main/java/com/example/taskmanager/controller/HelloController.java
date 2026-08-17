package com.example.taskmanager.controller;


import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final TaskServices taskServices;

    public HelloController(TaskServices taskServices){
        this.taskServices=taskServices;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "params-->" + name;
    }

//   post APIs

// test inComplete POSTMAN STATUS == TRUE

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task){
        return taskServices.createTask(task);
    }

    @GetMapping("/task")
    public List<Task> getAllTask(){
        return taskServices.getAllTask();
    }
}