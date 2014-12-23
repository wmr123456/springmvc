<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/22
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <style>
        .errorClass{
            color: #ff0000;
            font-weight: blod;
            border-color: #ff0000;;
        }
    </style>
</head>
<body>
    ${msg}
<form:form modelAttribute="stu1" action="/stu/new" method="post">
    <%--<label>I &nbsp;D</label>--%>
    <%--<form:input path="id"></form:input><form:errors path="id" cssClass="errorClass"></form:errors>--%>
    <%--<br>--%>
    <label>用户名：</label>
    <form:input path="name"/><form:errors path="name" cssClass="errorClass"></form:errors>
    <br/>
    <label>密 &nbsp;码：</label>
    <form:input path="password"/><form:errors path="password" cssClass="errorClass"></form:errors>
    <br>
    <input type="submit"/>
</form:form>
</body>
</html>
