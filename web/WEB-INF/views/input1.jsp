<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
${error_msg}
<form:form action="/hello/method4" method="post" modelAttribute="user">
    <form:select path="id" items="${users}" itemValue="id" itemLabel="name">

    </form:select>
    <input type="submit">
</form:form>
</body>
</html>
