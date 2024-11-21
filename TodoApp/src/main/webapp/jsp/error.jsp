<%@ page session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Error</title>
</head>
    <body>
        <h1>Oops... error occurred</h1>
        <p>${requestScope.error}</p>
        <a href="<c:url value='/'/>">Go back to the homepage</a>
    </body>
</html>
