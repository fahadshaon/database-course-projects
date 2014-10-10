<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Expressions Page</title>
</head>
<body>
<h1>Expressions</h1>
<ul>
    <li>
        Display current time using Date class
        <p><b>Current time: </b><%= new java.util.Date() %> </p>
    </li>
    <li>
        Display random number using Math class
        <p><b>Random number: </b><%= Math.random() %></p>
    </li>
    <li>
        Use implicit objects
        <ul>
            <li><b>Name parameter:</b> <%= request. getParameter("name") %></li>
            <li><b>Server: </b><%= application.getServerInfo() %></li>
            <li><b>Session ID: </b><%= session.getId() %></li>
        </ul>
    </li>
</ul>
</body>
</html>
