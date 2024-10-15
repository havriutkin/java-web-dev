package org.example.hw3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LandingServlet extends HttpServlet {
    // Check if user visited before using cookies.
    // Redirect to landing (index) page if not visited before.
    // If visited before, redirect to login page.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        boolean visited = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visited")) {
                    visited = true;
                    break;
                }
            }
        }
        if (visited) {
            response.sendRedirect("login.html");
        } else {
            Cookie cookie = new Cookie("visited", "true");
            response.addCookie(cookie);
            response.sendRedirect("index.html");
        }
    }
}
