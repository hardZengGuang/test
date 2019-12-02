<%--
  Created by IntelliJ IDEA.
  User: zeng
  Date: 2019/6/11
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/SL/login" method="post">
    姓名：<input type="text" name="name"><br>
    密码：<input type="password" name="psw"><br>
    记住我：<input type="checkbox" name="remember" value="1"><br>

    <input type="submit" value="登录">
</form>
</body>
</html>
