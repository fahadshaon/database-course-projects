<%--
@author: Fahad Shaon (http://www.shaon.org)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><decorator:title default="Tasks App"/></title>

    <link href="<c:url value="/static/bootstrap-3.2.0/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<c:url value="/static/ie/html5shiv-3.7.2.min.js"/>"></script>
    <script src="<c:url value="/static/ie/respond-1.4.2.min.js"/>"></script>
    <![endif]-->
    <style type="text/css">
        div.form-errors {
            color: red;
            padding: 5px 0;
        }
        div.confirm-message {
            font-size: 1.5em;
            margin-bottom: 0.7em;
        }
        .item-add-textarea {
            margin-bottom: 0.5em;
        }
        ul.done-list {
            color: #777;
            text-decoration: line-through;
        }
        h2.top-nav a:hover {
            text-decoration: none;
        }
    </style>

    <decorator:head/>
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="header">
                <ul class="nav nav-pills pull-right" role="tablist">
                    <li role="presentation"><a href="<c:url value="/t/" />">Home</a></li>
                </ul>
                <h2 class="top-nav"><a href="<c:url value="/t/task/" />">Tasks</a></h2>
            </div>
        </div>
    </div>

    <decorator:body/>
</div>
<script src="<c:url value="/static/jquery-1.11.1/jquery.min.js"/>"></script>
<script src="<c:url value="/static/bootstrap-3.2.0/js/bootstrap.min.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<c:url value="/static/ie/ie10-viewport-bug-workaround.js"/>"></script>
</body>
</html>