import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateServlet extends HttpServlet {

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

            String sql = "UPDATE employee SET ename = ?, "
                    + "department = ?, salary = ? "
                    + "WHERE empid = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ename);
            ps.setString(2, department);
            ps.setDouble(3, Double.parseDouble(salary));
            ps.setInt(4, Integer.parseInt(empid));

            int rows = ps.executeUpdate();
            out.println("<h3>" + rows + " record(s) updated successfully.</h3>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error while updating record: " + e.getMessage() + "</h3>");
        }
    }
}