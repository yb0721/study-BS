<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"  %>
<%@page import = "entities.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title></title>
    </head>
    <body>
        <%
            User user = new User();
            user.setUname("yang");
            user.setUpwd("123456");

            request.setAttribute("user", user);

            out.println("用户名："+user.getUname()+"<br/>");
            out.println("密码："+user.getUpwd()+"<br/>");

            List listarray=new ArrayList();
            listarray.add("1");
            listarray.add("2");
            listarray.add("3");
            request.setAttribute("listarray",listarray);
        %>
        用户名：${requestScope.user.uname}<%--  requestScope主要用于数据的展示 --%>
        密码：${requestScope.user.upwd}<br/>

        <c:forEach var="item" items="${requestScope.listarray}">  <%-- 与上面的引用相结合，jstl核心标签，用于循环上面的数组数据，“item”可自行更改 --%>
            ${item}<br/>
        </c:forEach>
        <br/>

        list数量为：${fn:length(listarray)} <%--  与上面的引用相结合，利用jstl函数标签显示数组长度 --%>
    </body>
</html>