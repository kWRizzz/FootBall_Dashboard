package com.example.taskmanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


// JPA Is declaring this Task object as an entity

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private boolean completed;
    public Task(){
    }

    public Task(String title, Boolean completed){
        this.title=title;
        this.completed=completed;
    }

    public long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}