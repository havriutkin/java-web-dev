package org.example.hw3;

import java.io.*;

import jakarta.servlet.http.*;

// Handles Login Using Sessions
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Redirect to login page
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to dashboard
            response.sendRedirect("/HW3_war/dashboard");
        } else {
            // Failed login
            // Redirect to login page
            response.sendRedirect("login.html");
        }
    }
}