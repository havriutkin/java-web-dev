package org.example.todoapp.service;

import org.example.todoapp.models.Task;
import org.example.todoapp.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public List<Task> getTasksByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT id, description, completed, deadline FROM tasks WHERE user_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setUserId(userId);
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getTimestamp("deadline"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void addTask(Task task) {
        String query = "INSERT INTO tasks (user_id, description, completed, deadline) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getUserId());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            if (task.getDeadline() != null) {
                statement.setTimestamp(4, new Timestamp(task.getDeadline().getTime()));
            } else {
                statement.setNull(4, Types.TIMESTAMP);
            }
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkTask(int taskId) {
        String query = "UPDATE tasks SET completed = NOT completed WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, taskId);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int taskId) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, taskId);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
