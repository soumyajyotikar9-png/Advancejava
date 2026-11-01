package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CreateCookiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Non-persistent cookie
        Cookie userCookie = new Cookie("User", "Soumya");

        // No maxAge means session/non-persistent cookie
        response.addCookie(userCookie);


        // Persistent cookie
        Cookie collegeCookie = new Cookie("College", "Amity");

        // 1 day = 24 * 60 * 60 seconds
        collegeCookie.setMaxAge(24 * 60 * 60);

        response.addCookie(collegeCookie);


        // Display success page

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookies Created Successfully</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Cookies Created Successfully!</h1>");

        out.println("<p>Non-Persistent: User = Soumya</p>");

        out.println("<p>Persistent: College = Amity (1 day)</p>");

        out.println("<br>");

        out.println("<a href='viewCookies'>View Cookies</a>");

        out.println("</body>");
        out.println("</html>");
    }
}