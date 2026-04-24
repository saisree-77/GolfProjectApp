<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
body {
    font-family: Arial;
    background-color: #f2f2f2;
}
.container {
    width: 400px;
    margin: 80px auto;
    padding: 20px;
    background: white;
    border-radius: 10px;
    box-shadow: 0px 0px 10px gray;
}
input, select {
    width: 100%;
    padding: 8px;
    margin: 8px 0;
}
button {
    width: 100%;
    padding: 10px;
    background: blue;
    color: white;
    border: none;
}
</style>

</head>
<body>

<div class="container">
    <h2>Register</h2>

    <form action="RegisterServlet" method="post">

        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <!-- PDF Requirement: Charity Selection -->
        <label>Select Charity:</label>
        <select name="charity">
            <option value="Charity A">Charity A</option>
            <option value="Charity B">Charity B</option>
            <option value="Charity C">Charity C</option>
        </select>

        <button type="submit">Register</button>

    </form>
</div>

</body>
</html>