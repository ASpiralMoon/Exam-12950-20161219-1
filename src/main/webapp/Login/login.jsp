<%--
  Created by IntelliJ IDEA.
  User: ASpiralMoon
  Date: 2016/12/19
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style title="text/css">
        body{
            color:#000;
            font-size:14px;
            margin:20px auto;
        }
    </style>
    <script type="text/javascript">
        function check(form) {
            if (document.forms.loginForm.userName.value=="") {
                alert("请输入用户名!")
                document.forms.loginForm.userName.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<form action="/loginContorller" method="post" name="loginForm">
    <table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
        <tr>
            <td colspan="2" aligin="center" bgcolor="#E8E8E8">用户登录</td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="提交" onclick="return check(this);"/>
                <input type="reset" name="重置" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
