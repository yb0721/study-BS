<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>

<html> 
    <head>
        <title>拦截器Test</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        ${sessionScope.uname}：登录成功！
        <form action = "login.action" method = "post">
            用户名：<input type = "text" name = "uname"><br/>
            <input type = "submit" value = "登录">
        </form>
    </body>
</html>
