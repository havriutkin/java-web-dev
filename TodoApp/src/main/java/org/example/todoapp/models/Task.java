package org.example.todoapp.models;

import java.util.Date;

public class Task implements java.io.Serializable{
    private int id;
    private int userId;
    private String description;
    private boolean completed;
    private Date deadline;

    public Task() {
    }

    public Task(int id, String description, int userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.completed = false;
        this.deadline = null;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
