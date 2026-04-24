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
<title>Subscription</title>
</head>
<body>

<h2>Select Subscription Plan</h2>

<form action="SubscriptionServlet" method="post">

    <input type="radio" name="plan" value="monthly" required> Monthly<br>
    <input type="radio" name="plan" value="yearly"> Yearly<br><br>

    <button type="submit">Subscribe</button>

</form>

</body>
</html>