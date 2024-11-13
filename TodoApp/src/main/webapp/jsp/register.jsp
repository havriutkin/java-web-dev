<%@ page session="false" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="register">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Register">
        </form>
        <a href="login.jsp">Login</a>
    </body>
</html>
