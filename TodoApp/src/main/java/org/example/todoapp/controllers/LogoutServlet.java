package org.example.todoapp.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    }
}
