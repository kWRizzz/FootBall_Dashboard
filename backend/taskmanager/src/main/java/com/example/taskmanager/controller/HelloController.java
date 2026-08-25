package com.example.taskmanager.controller;


import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
    public Task createTask(@Valid @RequestBody TaskRequest request){
        return taskServices.createTask(request);
    }

    @GetMapping("/task")
    public List<Task> getAllTask(){
        return taskServices.getAllTask();
    }


    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable Long id){
        return  taskServices.gerTaskById(id);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskServices.updateTask(id,task);
    }

    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable Long id){
          taskServices.deleteTask(id);
          return "Task delete";
    }
}