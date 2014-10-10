<%--
@author: Fahad Shaon (http://www.shaon.org)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks App - Task List</title>
</head>
<body>

<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="page-header">
            <h2>Tasks List</h2>
        </div>

        <table class="table table-bordered table-stripped">
            <tr>
                <th>Title</th>
                <th></th>
            </tr>
            <c:forEach items="${tasks}" var="t">
                <c:url value="/t/task/detail" var="detailUrl">
                    <c:param name="task_id" value="${t.taskId}"/>
                </c:url>
                <c:url value="/t/task/save" var="editUrl">
                    <c:param name="task_id" value="${t.taskId}"/>
                </c:url>
                <c:url value="/t/task/delete" var="deleteUrl">
                    <c:param name="task_id" value="${t.taskId}"/>
                </c:url>
                <tr>
                    <td><a href="${detailUrl}"><c:out value="${t.title}"/></a></td>
                    <td class="text-center">
                        <a href="${editUrl}" class="btn btn-sm btn-default">
                            <span class="glyphicon glyphicon-edit"></span>
                        </a>
                        <a href="${deleteUrl}" class="btn btn-sm btn-default">
                            <span class="glyphicon glyphicon-trash"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="text-center">
            <a href="<c:url value="/t/task/save" />" class="btn btn-info">
                <span class="glyphicon glyphicon-plus-sign"></span> Add New Task
            </a>
        </div>

    </div>
</div>
</body>
</html>
