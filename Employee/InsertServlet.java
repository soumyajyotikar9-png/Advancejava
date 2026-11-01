import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class InsertServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");
        String ename = request.getParameter("ename");
        String department = request.getParameter("department");
        String salary = request.getParameter("salary");

        try {
           Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee_management",
        "root",
        "1234"
);

            String sql = "INSERT INTO employee "
                    + "(empid, ename, department, salary) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(empid));
            ps.setString(2, ename);
            ps.setString(3, department);
            ps.setDouble(4, Double.parseDouble(salary));

            int rows = ps.executeUpdate();
            out.println("<h3>" + rows + " record(s) inserted successfully.</h3>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error while inserting record: " + e.getMessage() + "</h3>");
        }
    }
}