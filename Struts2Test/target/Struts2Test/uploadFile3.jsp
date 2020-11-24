<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>文件的下载</title>
    </head>

    <body>
        <s:fielderror/>
        <form action = "downFile.action" method = "post" enctype = "multipart/form-data">
            <input type = "file" name = "pic"><br/>
            <input type = "file" name = "pic"><br/>
            <input type = "file" name = "pic"><br/>
            <input type = "submit" value = "提交">
        </form>

        <s:if test="picFileName!=null">
            <s:iterator value="picFileName" var="name">
                <a href="downFile.action?fileName=<s:property value='name'/>"> <s:property value='name'/>  </a><br/>
            </s:iterator>
        </s:if>
        
    </body>
</html>