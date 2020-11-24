<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>添加书籍信息</title>
    </head>

    <body>
        <h2>填写书籍信息</h2>
        <s:form action = "show.action" method = "post">
            <s:textfield name = "book.bookname" label = "书名"/><br/>
            <s:textfield name = "book.author" label = "作者"/><br/>
            <s:textfield name = "book.introduced" label = "简介"/><br/>
            <s:textfield name = "book.press" label = "出版社"/><br/>

            <s:submit value = "提交"/>
        </s:form>
    </body>
</html>