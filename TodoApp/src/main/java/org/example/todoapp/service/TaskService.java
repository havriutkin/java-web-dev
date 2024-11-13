package org.example.todoapp.service;

import java.util.ArrayList;
import java.util.List;
import org.example.todoapp.models.Task;

public class TaskService {
    // Create mutable list of tasks and initialize it with three tasks
    private List<Task> tasks = new ArrayList<Task>() {{
        add(new Task(1, "Task 1", 1));
        add(new Task(2, "Task 2", 1));
        add(new Task(3, "Task 3", 1));
    }};

    public List<Task> getTasksByUserId(int userId) {
        // Create mock list of tasks for testing
        return this.tasks;
    }

    public void addTask(Task task) {
        // Implement this method
        this.tasks.add(task);
    }

    public void checkTask(int taskId) {
        // Find the task by id and update it
        for (Task t : this.tasks) {
            if (t.getId() == taskId) {
                t.setCompleted(!t.isCompleted());
            }
        }
    }

    public void deleteTask(int taskId) {
        this.tasks.removeIf(t -> t.getId() == taskId);
    }

}
