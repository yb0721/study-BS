<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
    <head>
        <title>MVCTest</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        ${sessionScope.uname}：登录成功！<br/>
        <form action = "login.action" method = "post">
            用户名：<input type = "text" name = "uname"/><br/>
            密码：<input type = "password" name = "upwd"/><br/>
            <input type = "submit" name = "button" value = "提交"/>
        </form>
    </body>
</html>
