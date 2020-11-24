<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>书籍信息确定</title>
    </head>
    
    <body>
        <s:form action = "add.action" method = "post">
            书名：<s:property value = "book.bookname" default = ""/><br/>
            作者：<s:property value = "book.author" default = ""/><br/>
            简介：<s:property value = "book.introduced" default = ""/><br/>
            出版社：<s:property value = "book.press" default = ""/><br/>

            <s:submit value = "确定提交"/>
        </s:form>
    </body>
</html>