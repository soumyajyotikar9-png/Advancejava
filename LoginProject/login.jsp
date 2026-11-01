<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>Login</title>

    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">

    <h2>Login</h2>

    <form action="check.jsp" method="post">

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login">

    </form>

    <p style="text-align:center;">
        Don't have an account?
        <a href="register.html">Register</a>
    </p>

</div>

</body>
</html>