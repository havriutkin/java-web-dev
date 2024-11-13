package org.example.todoapp.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.todoapp.models.Task;
import org.example.todoapp.models.User;
import org.example.todoapp.service.AuthService;
import org.example.todoapp.service.TaskService;
import org.example.todoapp.service.UserService;

import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private UserService userService;
    private AuthService authService;
    private TaskService taskService;

    public void init() {
        userService = new UserService();
        taskService = new TaskService();
        authService = new AuthService(userService);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("action").equals("login")) {
            // Handle login request
            handleLogin(request, response);
        } else {
            // Handle register request
            handleRegister(request, response);
        }
    }

    public void destroy() {
        userService = null;
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authService.login(username, password)) {
            // Get user
            User user = userService.getUserByUsername(username);

            // Set user in session
            request.getSession().setAttribute("user", user);

            // Get users tasks
            List<Task> taskList = taskService.getTasksByUserId(user.getId());
            for (Task task : taskList) {
                System.out.println(task.getDescription());
            }
            request.getSession().setAttribute("taskList", taskList);

            // Redirect to tasks page
            response.sendRedirect(request.getContextPath() + "/jsp/tasks.jsp");
        } else {
            // Redirect to login page with error message
            // todo: Add error message
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authService.register(username, password)) {
            // Redirect to login page with success message
            // todo: add success message
            response.sendRedirect("login.jsp");
        } else {
            // Redirect to register page with error message
            // todo: add error message
            response.sendRedirect("register.jsp");
        }
    }
}
