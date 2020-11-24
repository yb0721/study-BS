<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>OGNL技术(单值数据类型转换)</title>
    </head>

    <body>
        <s:form action = "showdata.action" method = "post">
            <s:textfield name = "message" label = "信息"/><br/>
            <s:textfield name = "user.name" label = "姓名"/><br/>
            <s:textfield name = "user.age" label = "年龄"/><br/>
            <s:textfield name = "user.address.country" label = "国家"/><br/>
            <s:textfield name = "user.address.city" label = "城市"/><br/>

            <s:textfield name = "hobbies" label = "爱好"/><br/>
            <s:textfield name = "hobbies" label = "爱好"/><br/>

            <s:textfield name = "number[0]" label = "数字"/><br/>
            <s:textfield name = "number[1]" label = "数字"/><br/>
            <s:textfield name = "number[2]" label = "数字"/><br/>

            <s:submit value = "提交"/>
        </s:form>

        <s:property value = "message" default = "默认为空！"/><br/>
        <s:property value = "user.name" default = "默认为空！"/><br/>
        <s:property value = "user.age" default = "默认为空！"/><br/>
        <s:property value = "user.address.country" default = "默认为空！"/><br/>
        <s:property value = "user.address.city" default = "默认为空！"/>

        <s:property value = "hobbies[0]"/><br/>
        <s:property value = "hobbies[1]"/><br/>
        <s:property value = "number[0]"/><br/>
        <s:property value = "number[1]"/><br/>
        <s:property value = "number[2]"/>
    </body>
</html>