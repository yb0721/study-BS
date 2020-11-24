<%@ page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>

<html>
    <head>
        <title>JSONTest</title>
        <script type = "text/javascript" src="webjars/jquery/1.10.2/jquery.min.js"></script>
        <script>
             $(document).ready(function () {
            // checkUserByJquery();
            $.getJSON("JsonServlet",function (result) {
                $.each(result,function (i,field) {
                    $("#json").append(field.dno+":"+field.dname+":"+field.loc+" ");
                });

            });
        });
        </script>
    </head>

    <body>
        <h2>Hello World!</h2>
        <p id = "json"></p>
    </body>
</html>
