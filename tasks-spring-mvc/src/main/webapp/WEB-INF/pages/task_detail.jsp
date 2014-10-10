<%--
@author: Fahad Shaon (http://www.shaon.org)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tasks App - Task Detail</title>
</head>
<body>

<c:if test="${empty task}">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="page-header">
                <h2>Task Detail</h2>
            </div>

            <div class="alert alert-warning">
                Task not found.
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty task}">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="page-header">
                <h2><c:out value="${task.title}"/></h2>
            </div>
        </div>
    </div>

    <c:url value="/t/task/item/state" var="actionUrl"/>

    <div class="row">
        <div class="col-md-5  col-md-offset-1">
            <h3>TODO</h3>
            <c:if test="${empty task.todoItemList}">
                <div class="alert alert-warning">
                    Nothing in todo list.
                </div>
            </c:if>

            <c:if test="${not empty task.todoItemList}">
                <ul class="list-group">

                    <c:forEach items="${task.todoItemList}" var="item">
                        <li class="list-group-item">
                            <c:out value="${item.title}"/>

                            <div class="pull-right">
                                <a href="#" class="btn btn-sm btn-default">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                                <a href="#" class="btn btn-sm btn-default">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>


                                <form:form method="post" action="${actionUrl}" role="form"
                                           cssStyle="display: inline-block !important;">
                                    <input type="hidden" name="task_id" value="${item.taskId}">
                                    <input type="hidden" name="item_id" value="${item.itemId}">
                                    <input type="hidden" name="new_state" value="1">
                                    <button type="submit" class="btn btn-sm btn-default">
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </form:form>

                            </div>
                            <div class="clearfix"></div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>

        </div>

        <div class="col-md-5">
            <h3>Done</h3>

            <c:if test="${empty task.doneItemList}">
                <div class="alert alert-warning">
                    Nothing done yet.
                </div>
            </c:if>

            <c:if test="${not empty task.doneItemList}">
                <ul class="list-group done-list">

                    <c:forEach items="${task.doneItemList}" var="item">
                        <li class="list-group-item">
                            <c:out value="${item.title}"/>
                            <div class="pull-right">
                                <a href="#" class="btn btn-sm btn-default">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                                <a href="#" class="btn btn-sm btn-default">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>

                                <form:form method="post" action="${actionUrl}" role="form"
                                           cssStyle="display: inline-block !important;">
                                    <input type="hidden" name="task_id" value="${item.taskId}">
                                    <input type="hidden" name="item_id" value="${item.itemId}">
                                    <input type="hidden" name="new_state" value="0">
                                    <button type="submit" class="btn btn-sm btn-default">
                                        <span class="glyphicon glyphicon-arrow-left"></span>
                                    </button>
                                </form:form>

                            </div>
                            <div class="clearfix"></div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-md-offset-3">
                <%--<c:url value="/t/task/detail" var="itemSaveUrl"/>--%>

            <form:form method="post" commandName="item" role="form">
                <form:input placeHolder="New todo item" cssClass="form-control item-add-textarea" path="title"/>
                <form:errors path="title" element="div" cssClass="form-errors"/>

                <div class="text-center">
                    <button type="submit" class="btn btn-info">
                        <span class="glyphicon glyphicon-plus-sign"></span> Add Item
                    </button>
                </div>
                <%--<input type="hidden" name="task_id" value="${task.taskId}" />--%>
            </form:form>
        </div>
    </div>
</c:if>


</body>
</html>
