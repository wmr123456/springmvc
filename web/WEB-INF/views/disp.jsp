<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/17
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String value = (String)request.getAttribute("data1");
    out.print(value);
%>
${data1}
${data2}
${data3}
</body>
</html>
