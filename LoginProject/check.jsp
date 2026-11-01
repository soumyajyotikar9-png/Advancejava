<%@ page import="java.sql.*" %>

<%
String email = request.getParameter("email");
String password = request.getParameter("password");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/loginDB",
        "root",
        "1234"
    );

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM users WHERE email=? AND password=?"
    );

    ps.setString(1, email);
    ps.setString(2, password);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {

        session.setAttribute("email", rs.getString("email"));
        session.setAttribute("name", rs.getString("name"));

        response.sendRedirect("profile.jsp");

    } else {

%>

<!DOCTYPE html>
<html>

<head>
    <title>Login Failed</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">

    <h2>Invalid Email or Password</h2>

    <p style="text-align:center;">
        <a href="login.jsp">Try Again</a>
    </p>

</div>

</body>
</html>

<%
    }

    rs.close();
    ps.close();
    con.close();

} catch (Exception e) {

    out.println("<h3>Error: " + e.getMessage() + "</h3>");

}
%>