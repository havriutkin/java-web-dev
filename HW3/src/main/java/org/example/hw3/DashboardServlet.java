package org.example.hw3;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class DashboardServlet extends HttpServlet {
    // Display Dashboard
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // If user is not logged in, redirect to login page
        if (username == null) {
            response.sendRedirect("login.html");
            return;
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Dashboard</title></head>");
        out.println("<body><h1>Welcome " + username + "</h1>");
        out.println("<p>This is a simple dashboard.</p>");
        out.println("</body></html>");
        out.close();
    }
}
