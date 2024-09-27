<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/27/2024
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CHào mừng ban ${sessionScope.containsKey("userLogin")?sessionScope.get("userLogin").fullName:""} đến với trang người dùng</h1>
</body>
</html>
