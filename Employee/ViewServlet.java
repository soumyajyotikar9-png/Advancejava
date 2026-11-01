import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_management",
                "root",
                "1234"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT * FROM employee"
            );

            out.println("<html>");
            out.println("<head><title>Employee Records</title></head>");
            out.println("<body>");

            out.println("<h2>Employee Records</h2>");

            out.println("<table border='1' cellpadding='10'>");

            out.println("<tr>");
            out.println("<th>Employee ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Department</th>");
            out.println("<th>Salary</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" +
                    rs.getInt("empid") + "</td>");

                out.println("<td>" +
                    rs.getString("ename") + "</td>");

                out.println("<td>" +
                    rs.getString("department") + "</td>");

                out.println("<td>" +
                    rs.getDouble("salary") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<br>");

            out.println("<a href='index.html'>Back to Home</a>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            out.println("<h3>Error: " +
                    e.getMessage() + "</h3>");
        }
    }
}