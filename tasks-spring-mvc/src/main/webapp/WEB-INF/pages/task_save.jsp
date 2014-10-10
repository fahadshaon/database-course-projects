<%--
@author: Fahad Shaon (http://www.shaon.org)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tasks App - Save Task</title>
</head>
<body>
<div class="row">
    <div class="col-md-10 col-md-offset-1">

        <div class="page-header">
            <h1>Save Task</h1>
        </div>

        <form:form method="post" commandName="task" class="form-horizontal" role="form">

            <div class="form-group">
                <form:label class="col-sm-2 control-label" path="title">Task Title</form:label>
                <div class="controls col-sm-10">
                    <form:input path="title" class="form-control"/>
                    <form:errors path="title" element="div" cssClass="form-errors"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input class="btn btn-success" type="submit" value="Save">
                    <input class="btn" type="reset" value="Reset">
                </div>
            </div>

            <form:hidden path="taskId"/>
        </form:form>


    </div>
</div>
</body>
</html>
