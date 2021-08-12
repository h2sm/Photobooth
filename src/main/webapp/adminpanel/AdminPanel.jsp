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
            <tr>
                <th>Имя</th>
                <th>Количество файлов</th>
                <th>Скачано?</th>
                <th>Код для загрузки</th>
            </tr>
            <tr>
                <td>Лена</td>
                <td>35</td>
                <td>true</td>
                <td>23</td>
            </tr>
            <tr>
                <td>Вася</td>
                <td>46</td>
                <td>true</td>
                <td>23–23,5</td>
            </tr>
            <tr>
                <td>Катя</td>
                <td>45</td>
                <td>true</td>
                <td>23,5</td>
            </tr>
            <tr>
                <td>Настя</td>
                <td>52</td>
                <td>false</td>
                <td>24</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
