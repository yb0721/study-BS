<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>jQueryTest1</title>
        <script type="text/javascript" src="webjars/jquery/1.10.2/jquery.js"></script>
        <%--    <script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>--%>

        <script type = "text/javascript">
            $(document).ready(function (){
                $("#btn").click(function (){
                    $("a").hide();  //   hide()方法：隐藏元素
                    $("#all").css("background-color", "blue");
                    $("#all").width(200);
                    //$("#all").css({"backgroundColor":"blue", "width":"100px"});
                });
            });
        </script>
    </head>

    <body>
        <a>链接</a>
        <p id = "all">段落文字</p>
        <button id = "btn">按钮</button>
    </body>
</html>
