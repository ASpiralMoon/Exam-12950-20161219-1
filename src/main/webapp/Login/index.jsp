<%--
  Created by IntelliJ IDEA.
  User: ASpiralMoon
  Date: 2016/12/19
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
<a href="/Login/insert.jsp">新增电影</a>
<br/><br/>
<table border="1">
    <tr>
        <th>film_id</th>
        <th>title</th>
        <th>description</th>
        <th>language</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${data}" var="d">
        <tr>
            <td>${d.film_id}</td>
            <td>${d.title }</td>
            <td>${d.description }</td>
            <td>${d.language.name }</td>
            <td><a href="/getContorller?film_id=${d.film_id }">编辑</a></td>
            <td><a href="/deleteContorller?film_id=${d.film_id }">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
