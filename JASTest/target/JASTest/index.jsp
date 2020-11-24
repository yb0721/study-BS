<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <title>jQuery+Ajax+Struts2综合使用</title>
        <script src="webjars/jquery/1.10.2/jquery.js"></script>
        <script>
            $(document).ready(
                function () {
                    checkUserByJquery();
                }
            );
            function checkUserByJquery() {
                $("#username").blur(function () {
                    var msg=document.getElementById("msg");
                    var username=document.getElementById("username");
                    if(username.value==""){
                        msg.innerText="用户名不能为空！";
                        username.focus();
                        return;
                    }
                var url="login.action";
                    //encodeURIComponent() 函数可把字符串作为 URI 组件进行编码。
                    var param="username="+encodeURIComponent(username.value);
                    //通过POST方法像服务器发送请求并获取返回值
                    $.post(url,{username:encodeURIComponent(username.value)},function (data,status) {
                        checkCallback(data,status);
                    });
                });
            }

            function checkCallback(data,status) {
                var msg=document.getElementById("msg");
                if("success"==status){
                    if("success"==data){
                        msg.innerText="该用户已经存在！"
                    }else{
                        msg.innerText="恭喜，可以注册！"
                    }
                }
            }

            
        </script>
    </head>
    <body>
        <h2>Hello World!</h2>
        用户名：<input type = "text" name = "username" id = "username"><span id = "msg"></span>
    </body>
</html>
