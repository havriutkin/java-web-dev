package org.example.todoapp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.todoapp.models.User;
import org.example.todoapp.service.TaskService;
import org.example.todoapp.models.Task;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private TaskService taskService;

    public void init() {
        taskService = new TaskService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // If there is no action parameter - handle check task
        if (request.getParameter("action") == null) {
            handleCheckTask(request, response);
        }
        else if (request.getParameter("action").equals("add")) {
            handleAddTask(request, response);
        }
        else if (request.getParameter("action").equals("delete")) {
            handleDeleteTask(request, response);
        }
    }

    private void handleAddTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Task task = new Task();
        task.setDescription(request.getParameter("description"));

        // Convert the string to a Date object
        if (request.getParameter("deadline").isEmpty()) {
            task.setDeadline(null);
        } else {
            try {
                Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deadline"));
                task.setDeadline(deadline);
            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute("error", "Invalid date format");
                request.getRequestDispatcher("/jsp/tasks.jsp").forward(request, response);
            }
        }

        // Get user from session
        User user = (User) request.getSession().getAttribute("user");
        task.setUserId(user.getId());
        task.setCompleted(false);

        // Set consecutive id
        taskService.addTask(task);

        List<Task> taskList = taskService.getTasksByUserId(user.getId());
        request.getSession().setAttribute("taskList", taskList);

        response.sendRedirect(request.getContextPath() + "/jsp/tasks.jsp");
    }

    private void handleDeleteTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        taskService.deleteTask(taskId);

        List<Task> taskList = taskService.getTasksByUserId(((User) request.getSession().getAttribute("user")).getId());
        request.getSession().setAttribute("taskList", taskList);
        response.sendRedirect(request.getContextPath() + "/jsp/tasks.jsp");
    }

    private void handleCheckTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        taskService.checkTask(taskId);

        List<Task> taskList = taskService.getTasksByUserId(((User) request.getSession().getAttribute("user")).getId());
        request.getSession().setAttribute("taskList", taskList);

        response.sendRedirect(request.getContextPath() + "/jsp/tasks.jsp");
    }
}
