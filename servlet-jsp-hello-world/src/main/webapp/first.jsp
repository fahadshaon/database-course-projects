<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>First JSP</title>
</head>
<body>
<h1>Test Heading</h1>
<p>Current Time <%= new java.util.Date() %></p>
<p><%
    int a = 10;
    int b = 20;

    out.println("Sum of " + a + " and " + b + " is " + (a + b));

%></p>

</body>
</html>
