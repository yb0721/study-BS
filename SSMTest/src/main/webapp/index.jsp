<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <body>
        <form action = "${BASE_PATH}/user/login" method = "post">
            <input type = "text" name = "uname"><br/>
            <input type = "password" name = "upwd"><br/>
            <input type = "submit" value = "登录">
        </form>
    </body>
</html>
