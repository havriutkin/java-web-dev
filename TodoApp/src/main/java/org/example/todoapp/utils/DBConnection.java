package org.example.todoapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Update with your database credentials
            String url = "jdbc:postgresql://localhost:5432/todo_app";
            String username = "your_db_username";
            String password = "your_db_password";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
