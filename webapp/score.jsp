<%@ page language="java" %>
<%@ page session="true" %>

<%
    Integer userId = (Integer) session.getAttribute("user_id");

    if (userId == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Enter Score</title>
</head>
<body>

<h2>Enter Your Golf Score</h2>

<form action="ScoreServlet" method="post">

    Game Date:
    <input type="date" name="game_date" required><br><br>

    Score:
    <input type="number" name="score" required><br><br>

    <button type="submit">Submit Score</button>

</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>