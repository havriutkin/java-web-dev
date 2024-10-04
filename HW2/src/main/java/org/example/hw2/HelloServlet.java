package org.example.hw2;

import java.io.*;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private ServletContext context;

    @Override
    public void init() {
        context = getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Hello World</title></head>");
        out.println("<body><h1>Hello World</h1>");
        out.println("<p>This is a simple servlet.</p>");

        out.println("<h2> Parameters: </h2>");
        Map<String, String[]> parameters = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            out.println("<p>" + entry.getKey() + ": " + String.join(", ", entry.getValue()) + "</p>");
        }

        out.println("<h2> Servlet Context: </h2>");
        out.println("<p>Server Info: " + context.getServerInfo() + "</p>");
        out.println("<p>Servlet Context Path: " + context.getContextPath() + "</p>");
        out.println("<p>Servlet Major Version: " + context.getMajorVersion() + "</p>");
        out.println("<p>Servlet Minor Version: " + context.getMinorVersion() + "</p>");
        out.println("<p>Servlet Context Name: " + context.getServletContextName() + "</p>");

        out.println("</body></html>");
        out.close();
    }
}