<%@ include file="header.jsp" %>

<h2>Enter Your Information</h2>
<form action="process.jsp" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" required /><br/>

    <label for="email">Email:</label>
    <input type="email" name="email" required /><br/>

    <label for="goals">How do you plan to use this app? (select multiple):</label><br/>
    <input type="checkbox" name="goals" value="Study" /> Study<br/>
    <input type="checkbox" name="goals" value="Work" /> Work<br/>
    <input type="checkbox" name="goals" value="Travel" /> Travel<br/>
    <input type="checkbox" name="goals" value="Life" /> Life<br/>

    <input type="submit" value="Submit" />
</form>

<%@ include file="footer.jsp" %>
