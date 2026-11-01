package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ViewCookiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String college = "Not Present";
        String user = "Not Present";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("College")) {
                    college = cookie.getValue();
                }

                if (cookie.getName().equals("User")) {
                    user = cookie.getValue();
                }
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookies Currently Present</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Cookies Currently Present</h1>");

        out.println("<p>Persistent Cookie: College = "
                + college + "</p>");

        out.println("<p>Non-Persistent Cookie: User = "
                + user + "</p>");

        out.println("<br>");

        out.println("<a href='createCookies'>Create Cookies</a>");

        out.println("</body>");
        out.println("</html>");
    }
}