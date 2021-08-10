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
    <link rel="stylesheet" href="<%=application.getContextPath() %>/css/styles.css" type="text/css"/>
    <title>Welcome!</title>
</head>
<body>
<h2>Введите ваш код</h2>

<form action='photobooth' method='post'>
    <input type='text' name='first'/>
    <input type='submit' name='submit'/>
</form>
</body>
</html>
