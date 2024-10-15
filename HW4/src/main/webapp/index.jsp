<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.Period" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculate Days Lived</title>
  </head>
<body>
  <h1>Current Date and Time</h1>

  <%
    // Get current date and time
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);
    out.println("<p>Today's Date: " + formattedDate + "</p>");
  %>

  <h2>Enter Your Birth Date</h2>

  <!-- Form to enter birthdate -->
  <form action="index.jsp" method="post">
    <label for="birthdate">Birthdate (yyyy-mm-dd):</label>
    <input type="date" id="birthdate" name="birthdate" required><br><br>
    <input type="submit" value="Calculate Days Lived">
  </form>

  <%
    // Check if the form was submitted
    String birthdate = request.getParameter("birthdate");

    if (birthdate != null && !birthdate.isEmpty()) {
      try {
        // Parse the birthdate entered by the user
        LocalDate birthDate = LocalDate.parse(birthdate);

        // Calculate the number of days lived
        long daysLived = ChronoUnit.DAYS.between(birthDate, currentDate);

        // Output the result
        out.println("<h3>You have lived " + daysLived + " days.</h3>");
      } catch (Exception e) {
        out.println("<p style='color: red;'>Invalid date format. Please use yyyy-mm-dd.</p>");
      }
    }
  %>

</body>
</html>
