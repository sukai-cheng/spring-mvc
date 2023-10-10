<jsp:useBean id="user" scope="page" type="com.sukai.entity.User"/>
<%--
  Created by IntelliJ IDEA.
  User: chengsukai
  Date: 2023/10/7
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, ${user.userName}</h1>
</body>
</html>
