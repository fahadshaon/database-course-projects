<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSTL - Jsp Standard Tag Library</title>
</head>
<body>
<h2>if</h2>

<c:set var="number" value="11"/>

<c:if test="${number%2 == 0}" >
    <p><c:out value="${number}"/> is Even</p>
</c:if>
<c:if test="${number%2 == 1}" >
    <p><c:out value="${number}"/> is Odd</p>
</c:if>
</body>
</html>
