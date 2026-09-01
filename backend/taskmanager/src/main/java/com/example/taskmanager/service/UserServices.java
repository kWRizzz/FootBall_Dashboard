package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public UserServices (UserRepository userRepository ,TaskRepository taskRepository,TaskMapper taskMapper)  {
        this.userRepository=userRepository;
        this.taskRepository=taskRepository;
        this.taskMapper=taskMapper;
    }


    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public List<TaskResponse> getUserTasks(Long userId){
        return taskRepository.findByUserId(userId)
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }
}
