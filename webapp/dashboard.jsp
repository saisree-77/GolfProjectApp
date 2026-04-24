<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.app.db.DBConnection" %>

<%
    String user = (String) session.getAttribute("user");
    Integer userId = (Integer) session.getAttribute("user_id");

    if (user == null || userId == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
</head>
<body>

<h2>Welcome <%= user %></h2>

<hr>

<!-- 🔹 Subscription Section -->
<%
    boolean hasSubscription = false;

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM subscriptions WHERE user_id=? ORDER BY sub_id DESC LIMIT 1"
        );

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            hasSubscription = true;
%>

<h3>Subscription Details</h3>
Plan: <%= rs.getString("plan_type") %><br>
Status: <%= rs.getString("status") %><br>
Start Date: <%= rs.getDate("start_date") %><br>
End Date: <%= rs.getDate("end_date") %><br>

<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (!hasSubscription) {
%>

<p>No active subscription</p>
<a href="subscription.jsp">Subscribe Now</a>

<%
    }
%>

<br><br>

<!-- 🔹 Navigation -->
<a href="score.jsp">Enter Score</a><br><br>
<a href="LuckyDrawServlet">Run Lucky Draw</a><br><br>
<a href="logout.jsp">Logout</a>

<hr>

<!-- 🔹 Score Section -->
<h3>Your Scores</h3>

<%
    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps2 = con.prepareStatement(
            "SELECT * FROM scores WHERE user_id=? ORDER BY score_id DESC"
        );

        ps2.setInt(1, userId);

        ResultSet rs2 = ps2.executeQuery();

        boolean hasScore = false;

        while (rs2.next()) {
            hasScore = true;
%>

<p>
Date: <%= rs2.getDate("game_date") %> |
Score: <%= rs2.getInt("score") %>
</p>

<%
        }

        if (!hasScore) {
%>
<p>No scores entered yet</p>
<%
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
%>

</body>
</html>