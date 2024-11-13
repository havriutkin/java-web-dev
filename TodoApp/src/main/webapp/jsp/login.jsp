<%@ page session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
    </head>
    <body>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="login">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
        Don't have an account? <a href="register.jsp">Register</a>
    </body>
</html>
