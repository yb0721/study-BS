<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
    <head>
        <title>Struts2Test</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <form action = "login.action" method = "post">
            用户名：<input type = "text" name = "uname"/><br/>
            密码：<input type = "password" name = "upwd"/><br/>
            <input type = "submit" value = "登录"/>
        </form>
    </body>
</html>
