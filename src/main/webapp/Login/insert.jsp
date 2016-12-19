<%--
  Created by IntelliJ IDEA.
  User: ASpiralMoon
  Date: 2016/12/19
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body>
<form action="/insertContorller" method="post" name="insertForm">
    <table border="1">
        <tr>
            <th>title</th>
            <th>description</th>
            <th>language</th>
        </tr>
        <tr>
            <td><input type="text" name="title"/></td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="提交" onclick="return check(this);"/>
                <input type="reset" name="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
