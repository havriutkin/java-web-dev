package org.example.todoapp.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.example.todoapp.utils.DBConnection;

@WebFilter("/*") // Apply to all requests
public class DBFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            // Attempt to get a database connection
            Connection connection = DBConnection.getConnection();
            if (connection == null || connection.isClosed()) {
                // Handle the case where the connection is not available
                request.setAttribute("error", "Database connection is unavailable.");
                request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
            return;
        }

        // Proceed with the request if the connection is okay
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
