<%@ page session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
    </head>
    <body>

        <h1>Register</h1>

        <!-- Check if an error exists -->
        <c:if test="${not empty requestScope.error}">
            <div class="error">${requestScope.error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/UserServlet" method="post">
            <input type="hidden" name="action" value="register">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Register">
        </form>
        Already have an account? <a href="${pageContext.request.contextPath}/jsp/login.jsp">Login</a>
    </body>
</html>
