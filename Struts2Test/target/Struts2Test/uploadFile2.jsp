<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>多文件的上传</title>
    </head>

    <body>
        <s:fielderror/>
        <form action = "fileUpload2.action" method = "post" enctype = "multipart/form-data">
            <input type = "file" name = "pic"><br/>
            <input type = "file" name = "pic"><br/>
            <input type = "file" name = "pic"><br/>
            <input type = "submit" value = "提交">
        </form>

        <%-- 文件的多文件上传 --%>
        <%-- <s:if test="picFileName!=null">
            <s:iterator value="picFileName" var="name">
                <img src="upload/<s:property value='name'/>"></img><br/>
            </s:iterator>
        </s:if> --%>

        <%-- 文件的下载 --%>
        <s:if test="picFileName!=null">
            <s:iterator value="picFileName" var="name">
                <a href="downFile.action?fileName=<s:property value='name'/>"> <s:property value='name'/>  </a><br/>
            </s:iterator>
        </s:if>
    </body>
</html>