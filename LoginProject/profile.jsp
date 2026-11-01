<%@ page import="java.sql.*" %>

<%
    // Get logged-in user's email
    String email = (String) session.getAttribute("email");

    // If user is not logged in
    if (email == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String name = "";
    String batch = "";
    String department = "";
    String mobile = "";

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/loginDB",
            "root",
            "1234"
        );

        PreparedStatement ps = con.prepareStatement(
            "SELECT name, batch, email, department, mobile FROM users WHERE email=?"
        );

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            name = rs.getString("name");
            batch = rs.getString("batch");
            email = rs.getString("email");
            department = rs.getString("department");
            mobile = rs.getString("mobile");

        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");

    }
%>

<!DOCTYPE html>
<html>

<head>

    <title>My Profile</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<div class="profile-container">

    <h1>Login Successful!</h1>

    <div class="profile-details">

        <div class="profile-row">
            <span class="profile-label">Name:</span>
            <%= name %>
        </div>

        <div class="profile-row">
            <span class="profile-label">Batch:</span>
            <%= batch %>
        </div>

        <div class="profile-row">
            <span class="profile-label">Email:</span>
            <%= email %>
        </div>

        <div class="profile-row">
            <span class="profile-label">Department:</span>
            <%= department %>
        </div>

        <div class="profile-row">
            <span class="profile-label">Mobile:</span>
            <%= mobile %>
        </div>

    </div>

    <a class="logout" href="logout.jsp">
        Logout
    </a>

</div>

</body>
</html>