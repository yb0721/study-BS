<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
    <head>
        <title>登录失败</title>
    </head>

    <body>
        ${sessionScope.uname}：没有此用户<br/>
        <p><a href = "reg.jsp">还没有账号?点击这里</a></p>
    </body>
</html>