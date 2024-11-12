<%@ page import="java.util.Arrays" %>
<%@ include file="header.jsp" %>

<h2>Submitted Information</h2>

<%
    // Get the form data
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String[] goals = request.getParameterValues("goals");

    out.println("<p>Name: " + name + "</p>");
    out.println("<p>Email: " + email + "</p>");

    if (goals != null) {
        out.println("<p>Goals: " + Arrays.toString(goals) + "</p>");
    } else {
        out.println("<p>No goals selected.</p>");
    }
%>

<%@ include file="footer.jsp" %>
