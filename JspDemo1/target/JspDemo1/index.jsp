<%@page import="java.util.*" %>
<%@page import="main.java.bean.User" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<body>
    <%
        User us = new User();
        us.setUid(1);
        us.setUname("root");
        us.setUpwd("123");
    %>
    <p>序号:<%=us.getUid()%></p>
    <P>用户名:<%=us.getUname()%></p>
    <p>密码:<%=us.getUpwd()%></p>
</body>
</html>
