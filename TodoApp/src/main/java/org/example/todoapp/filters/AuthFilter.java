package org.example.todoapp.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean isLoginPage = path.equals("/jsp/login.jsp") || path.equals("/jsp/register.jsp");
        boolean isStaticResource = path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/images/");

        if (loggedIn || isLoginPage || isStaticResource) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
        }
    }

    public void destroy() {}
}
