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
    <title>Вход в админку</title>
</head>
<style>
    <%@include file="/css/styles.css" %>
</style>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <h2 class="active"> Админка </h2>

        <form action="j_security_check" method="post">
            <input type="text" id="login" class="fadeIn second" name="j_username" placeholder="Логин">
            <input type="text" id="password" class="fadeIn third" name="j_password" placeholder="Пароль">
            <input type="submit" class="fadeIn fourth" value="Войти" name="submit">
        </form>


    </div>
</div>
</body>
</html>
