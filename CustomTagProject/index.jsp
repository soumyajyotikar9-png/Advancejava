<%@ taglib prefix="my" uri="http://mytags" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>

<body>

    <h2>Custom tag that gives Forward and Include Actions</h2>

    <my:mytag action="include" page="welcome.jsp"/>

    <br><br>

    <a href="forward.jsp">Go to Thank You Page</a>

</body>
</html>