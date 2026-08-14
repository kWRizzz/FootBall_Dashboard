package com.example.taskmanager.controller;


import com.example.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "params-->" + name;
    }
//   post apis
// test inComplete POSTMAN STATUS == FALSE
    @PostMapping("/task")
    public Task createTast(@RequestBody Task task){
        return task;
    }
}