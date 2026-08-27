package com.example.taskmanager.mapper;

import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {

    public TaskResponse toResponse(Task task){

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.isCompleted()
        );
    }
}
