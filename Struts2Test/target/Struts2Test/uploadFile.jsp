<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>单文件上传</title>
    </head>
    <body>
         <s:fielderror/>
        <form action = "fileUpload.action" method = "post" enctype = "multipart/form-data">
            <input type = "file" name = "pic"><br/>
            <input type = "submit" value = "提交">
        </form>

        <img src = "<s:property value =" 'upload/'+picFileName"/>"/>
    </body>
</html>