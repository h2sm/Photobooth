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
    <link rel="stylesheet" href="<%=application.getContextPath() %>/css/admincss.css" type="text/css"/>
    <link rel="stylesheet" href="<%=application.getContextPath() %>/css/styles.css" type="text/css"/>


</head>
<body>
<h2>You logged in</h2>
<%--<form action='${pageContext.request.contextPath}/admin' method='post'>--%>
<%--    <input type='text' name='firstparam'/>--%>
<%--    <input type='submit' name='submit'/>--%>
<%--</form>--%>
<div class="upload">
    <section class="maintext">
        <h3>Загрузить файлы</h3>
<%--        enctype="multipart/form-data"--%>
        <form method="post" action='${pageContext.request.contextPath}/admin' >
<%--            <input type="file" name="file" multiple/>--%>
            <input type="text" name="personName" value="Имя"/>
            <input type="submit" value="Загрузить" />
        </form>
    </section>
</div>
</body>
</html>
