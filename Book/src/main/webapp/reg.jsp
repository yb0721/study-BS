<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>

<html>
    <head>
        <title>注册新管理员</title>
    </head>

    <body>
        <h2>Welcome Registered!</h2>
        <form action = "reg.action" method = "post">
            用户名：<input type = "text" name = "uname"/><br/>
            密码：<input type = "password" name = "upwd"/><br/>
            <input type = "submit" value = "提交"/>
        </form>
    </body>
</html>