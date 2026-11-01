import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class DeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee_management",
        "root",
        "1234"
);
            String sql = "DELETE FROM employee WHERE empid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(empid));

            int rows = ps.executeUpdate();
            out.println("<h3>" + rows + " record(s) deleted successfully.</h3>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error while deleting record: " + e.getMessage() + "</h3>");
        }
    }
}