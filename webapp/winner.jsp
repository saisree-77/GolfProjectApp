<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Winner</title>
</head>
<body>

<h2> Lucky Draw Winner </h2>

<%
    String winner = (String) request.getAttribute("winner");

    if (winner != null) {
%>

<h3>Winner: <%= winner %></h3>

<%
    } else {
%>

<p>No participants yet</p>

<%
    }
%>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>