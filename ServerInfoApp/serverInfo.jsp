<%@ page import="java.net.InetAddress" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    String clientIp = request.getRemoteAddr();

    StringBuffer urlBuffer = request.getRequestURL();
    String query = request.getQueryString();
    if (query != null) {
        urlBuffer.append("?").append(query);
    }

    String contextPath = application.getContextPath();
    String serverInfo = application.getServerInfo();

    // Application-scoped counter; synchronize updates so simultaneous requests
    // do not lose increments.
    Integer hitCount;
    synchronized (application) {
        Integer current = (Integer) application.getAttribute("hitCount");
        hitCount = (current == null) ? 1 : current + 1;
        application.setAttribute("hitCount", hitCount);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Server Information</title>
</head>
<body>
    <h1>Server-Side Information</h1>
    <p>Client IP Address: <%= clientIp %></p>
    <p>URL: <%= urlBuffer %></p>
    <p>Context Path: <%= contextPath %></p>
    <p>Server Info: <%= serverInfo %></p>
    <p>Application Hit Count: <%= hitCount %></p>
</body>
</html>