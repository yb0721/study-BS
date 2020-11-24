<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
    <head>
        <title>Hello</title>
    </head>

    <body>
        <h2>Welcome</h2>
        ${requestScope.get("message")}
    </body>
</html>