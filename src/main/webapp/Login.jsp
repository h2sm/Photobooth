<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.08.2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=application.getContextPath() %>/css/styles.css" type="text/css"/>
    <title>Вход в админку</title>
</head>
<body>
<form action="j_security_check" method="post">
    Логин:<input type="text" name="j_username"/> <br/>
    Пароль:<input type="password" name="j_password"/> <br/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
