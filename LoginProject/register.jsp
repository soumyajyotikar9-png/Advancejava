<%@ page import="java.sql.*" %>

<%
String name = request.getParameter("name");
String batch = request.getParameter("batch");
String email = request.getParameter("email");
String department = request.getParameter("department");
String mobile = request.getParameter("mobile");
String password = request.getParameter("password");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/loginDB",
        "root",
        "1234"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO users (name, batch, email, department, mobile, password) VALUES (?, ?, ?, ?, ?, ?)"
    );

    ps.setString(1, name);
    ps.setString(2, batch);
    ps.setString(3, email);
    ps.setString(4, department);
    ps.setString(5, mobile);
    ps.setString(6, password);

    ps.executeUpdate();

    ps.close();
    con.close();

%>

<!DOCTYPE html>
<html>

<head>

    <title>Registration Successful</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<div class="success-container">

    <h2>Registration Successful!</h2>

    <div class="details">

        <p>
            <span>Name:</span>
            <%= name %>
        </p>

        <p>
            <span>Batch:</span>
            <%= batch %>
        </p>

        <p>
            <span>Email:</span>
            <%= email %>
        </p>

        <p>
            <span>Department:</span>
            <%= department %>
        </p>

        <p>
            <span>Mobile:</span>
            <%= mobile %>
        </p>

    </div>

    <a class="login-link" href="login.jsp">
        Go to Login
    </a>

</div>

</body>
</html>

<%

} catch (Exception e) {

    out.println("<h2>Registration Failed</h2>");
    out.println("<p>Error: " + e.getMessage() + "</p>");

}

%>