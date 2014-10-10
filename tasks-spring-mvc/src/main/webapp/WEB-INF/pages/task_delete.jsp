<%--
@author: Fahad Shaon (http://www.shaon.org)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tasks App - Delete task confirmation</title>
</head>
<body>

<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="page-header">
            <h2>Task Delete Confirmation</h2>
        </div>

    </div>
</div>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${empty task}">
            <div class="alert alert-warning text-center">
                Task not found
            </div>
        </c:if>

        <c:if test="${not empty task}">

            <div class="well">

                <div class="confirm-message">
                    Delete task "<em><c:out value="${task.title}"/></em>" and all related items?
                    This action can not be reverted.
                </div>

                <div class="text-center">
                    <form:form cssClass="form-inline" method="post" commandName="task">
                        <a class="btn btn-default" href="<c:url value="/t/task" /> ">Cancel</a>

                        <form:hidden path="taskId"/>
                        <input type="hidden" name="confirm_delete" value="1">
                        <button type="submit" class="btn btn-danger">
                            <span class="glyphicon glyphicon-trash"></span> Delete
                        </button>
                    </form:form>
                </div>
            </div>

        </c:if>
    </div>
</div>

</body>
</html>
