<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
    <body>
        <%-- <%=session.getAttribute("username")%>:登录成功！ --%>
        ${sessionScope.username}:登录成功！
        <a href = "success2.jsp">跳转</a>
    </body>
</html>