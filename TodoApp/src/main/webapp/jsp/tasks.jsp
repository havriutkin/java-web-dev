<%@ page import="org.example.todoapp.models.Task, java.util.List" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="ct" uri="https://todoapp/customtags" %>



<jsp:useBean id="taskList" scope="session" type="java.util.List" />
<html>
    <head>
        <title>Your Tasks</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/tasks.css'/>">
    </head>
    <body>
        <h1>Your To-Do List</h1>

        <form id="new-task" action="<c:url value='/TaskServlet' />" method="post">
            <input type="hidden" name="action" value="add">
            <div id="new-task-group">
                <label id="description">
                    Task:
                    <input type="text" name="description">
                </label>
                <label id="deadline">
                    Deadline (optional):
                    <input type="date" name="deadline">
                </label>
            </div>

            <div id="new-task-submit">
                <input type="submit" value="Add Task">
            </div>
        </form>

        <h2>Tasks</h2>
        <ul style="width: 60%;">
            <c:forEach var="task" items="${taskList}">
                <li>
                    <form class="task" action="<c:url value='/TaskServlet' />" method="post">
                        <input type="hidden" name="taskId" value="${task.id}">
                        <input type="checkbox" name="completed" ${task.completed ? "checked" : ""} onchange="this.form.submit()">
                            ${task.description}
                        <ct:deadline deadline="${task.deadline}" />
                        <button type="submit" name="action" value="delete">Delete</button>
                    </form>
                </li>
            </c:forEach>
        </ul>
        <a href="">Logout</a>
    </body>
</html>
