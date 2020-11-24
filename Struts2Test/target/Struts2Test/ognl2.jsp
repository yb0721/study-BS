<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>ognl技术(多值数据转换)</title>
    </head>

    <body>
        <s:form action = "showdata.action" method = "post">
            <s:textfiled name = "hobbies" label = "爱好"/><br/>
            <s:textfiled name = "hobbies" label = "爱好"/><br/>

            <s:textfiled name = "number[0]" label = "数字"/><br/>
            <s:textfiled name = "number[1]" label = "数字"/><br/>
            <s:textfiled name = "number[2]" label = "数字"/><br/>
            <s:submit value = "提交"/>
        </s:form>

        <s:property value = "hobbies[0]"/><br/>
        <s:property value = "hobbies[1]"/><br/>
        <s:property value = "number[0]"/><br/>
        <s:property value = "number[1]"/><br/>
        <s:property value = "number[2]"/>
    </body>
</html>