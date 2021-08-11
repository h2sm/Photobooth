<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.08.2021
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка</title>
</head>
<body>
<h2>You logged in</h2>
<form action='${pageContext.request.contextPath}/admin' method='post'>
    <input type='text' name='firstparam'/>
    <input type='submit' name='submit'/>
</form>

</body>
</html>
