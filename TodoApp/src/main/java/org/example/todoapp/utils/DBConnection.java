package org.example.todoapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Explicitly load the PostgreSQL driver
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("PostgreSQL JDBC Driver is missing. Check your classpath!", e);
            }

            // Connection details
            String url = "jdbc:postgresql://localhost:5432/java_todo_db";
            String username = "java_todo_admin";
            String password = "java_todo_admin";

            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
