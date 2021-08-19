<%@ page import="database.DBFactory" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="database.DBInterface" %><%--
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
</head>
<body>
<h2 align="center">Админка</h2>
<div class="controls">
    <div class="uploadContent">
        <h3>Загрузить файлы</h3>
        <form method="post" action='${pageContext.request.contextPath}/admin' enctype="multipart/form-data">
            <input type="text" id="personName" name="personName" value="Имя">
            <input type="file" name="chosenFiles" multiple>
            <input type="submit" value="Загрузить">
        </form>
    </div>
    <div class="statisticsContent">
        <h3>Статистика</h3>
        <table border="1" class="statsTable">
            <TR>
                <th>Имя</th>
                <th>Код скачивания</th>
                <th>Путь до файлов</th>
                <th>Скачано?</th>
            </TR>
        <%
            try {
                DBInterface instance = DBFactory.getInstance();
                ResultSet res = instance.getAllData();
                while (res.next()) {
        %>
            <tr>
                <th><%=res.getString("username")%></th>
                <th><%=res.getInt("code")%></th>
                <th><%=res.getString("pathto")%></th>
                <th><%=res.getBoolean("hasdownloaded")%></th>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
