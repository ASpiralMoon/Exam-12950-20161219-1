<%--
  Created by IntelliJ IDEA.
  User: ASpiralMoon
  Date: 2016/12/19
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑页面</title>
    <script type="text/javascript">
        function check(form) {
            if (document.forms.editFilm.title.value == "") {
                alert("请输入电影标题!")
                document.forms.editFilm.title.focus();
                return false;
            }
            if (document.forms.editFilm.description.value == "") {
                alert("请输入电影描述!")
                document.forms.editFilm.description.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<form action="/editContorller" method="post" name="editFilm">
    <%--<table border="1">--%>
        <%--<tr>--%>
            <%--<th>title</th>--%>
            <%--<th>description</th>--%>
            <%--<th>language</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><input type="text" name="title">${data1.title}</td>--%>
            <%--&lt;%&ndash;<td><textarea rows="3" cols="20" name="description">${data1.description}</textarea></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:forEach items="${data2}" var="d">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<select name="language">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<option value="${data2.language_id}">${data2.name}</option>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2" align="center">--%>
                <%--<input type="submit" name="提交" onclick="return check(this);"/>--%>
                <%--<input type="reset" name="重置"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
        <table border="1">
            <tr>
                <th>title</th>
                <th>description</th>
                <th>language</th>
            </tr>
            <tr>
                <c:forEach items="${data1}" var="list">
            <tr>
                <td align="center">${list.title}</td>
                <td align="center">${list.description}</td>
            </tr>
            </c:forEach>
        </table>


</form>
</body>
</html>
