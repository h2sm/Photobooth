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
</head>
<style>
    <%@include file="/css/styles.css" %>
</style>
<body>
<div class="wrapper fadeInDown">
    <div class="formContent">
        <div class="uploadShit">
            <h2 class="active"> Админка </h2>
            <h3>Загрузить файлы</h3>
            <form method="post" action='${pageContext.request.contextPath}/admin' enctype="multipart/form-data">
                <input type="text" id="personName" class="fadeIn second" name="personName" value="Имя">
                <input type="file" name="chosenFiles" class="fadeIn third" multiple>
                <input type="submit" class="fadeIn fourth" value="Загрузить">
            </form>
        </div>
        <h3>Статистика</h3>
        <table border="1" class="statsTable">
            <TR>
                <th>Имя</th>
                <th>Код скачивания</th>
                <th>Путь до файлов</th>
                <th>Скачано?</th>
                <th>а</th>
            </TR>
            <%
                try {
                    DBInterface instance = DBFactory.getInstance();
                    ResultSet res = instance.getAllData();
                    while (res.next()) {
            %>
            <tr>
                <th><%=res.getString("username")%>
                </th>
                <th><%=res.getInt("code")%>
                </th>
                <th><%=res.getString("pathto")%>
                </th>
                <th><%=res.getBoolean("hasdownloaded")%>
                </th>
                <th>
                    <form method="post" action="${pageContext.request.contextPath}/admin?delete_id=<%=res.getInt("code") %>">
                            <button type="submit" value="delete">Delete</button>
                    </form>
                </th>
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
