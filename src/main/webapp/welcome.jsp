<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.08.2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css"/>--%>
    <title>Скачать фото</title>
</head>
<style>
    <%@include file="/css/styles.css" %>
</style>
<body>
<%--<div class="mainCodeCheck">--%>
<%--    <h2>Введите ваш код</h2>--%>
<%--    <form action='photobooth' method='post'>--%>
<%--        <input type='text' name='first'/>--%>
<%--        <input type='submit' name='submit'/>--%>
<%--    </form>--%>
<%--</div>--%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <h2 class="active"> Введите код </h2>

        <form action="photobooth" method="post">
            <input type="text" id="login" class="fadeIn second" name="first">
<%--            <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">--%>
            <input type="submit" class="fadeIn fourth" value="Скачать" name="submit">
        </form>


    </div>
</div>
</body>
</html>

