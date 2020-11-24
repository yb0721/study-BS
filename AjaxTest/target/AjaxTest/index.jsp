<%@ page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>

<html>
    <head>
        <title>AjaxTest</title>
        <script type = "text/javascript" src="webjars/jquery/1.10.2/jquery.min.js"></script>

        <%-- <script type = "text/javascript">
            function createXmlHttpRequest() {
                if(window.ActiveXObject){
                    //IE浏览器版本
                    return new ActiveXObject("Microsoft.XMLHTTP");
                }else{
                    return new XMLHttpRequest();
                }
            }            

            function checkuser() {
                var msg = document.getElementById("sp");
                var username = document.getElementById("username");
                if(username.value=="") {
                    msg.innerText = "用户名不能为空！";
                    username.focus(); //focus()表示输入框获得焦点
                    return;
                }
                var url="userServlet";
                var param="username="+username.value;
                //1、获取ajax核心对象XmlHttpRequest
                xmlhttprequest=createXmlHttpRequest();
                //2、打开ajax请求路径
                xmlhttprequest.open("POST",url,true);
                //3、配置ajax请求的回调处理函数
                xmlhttprequest.onreadystatechange=callBack;
                //4、处理请求消息头
                xmlhttprequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
                //5、发送请求
                xmlhttprequest.send(param);
            }

            function callBack() {
                var msg = document.getElementById("sp");
                msg.innerText="";
                if(xmlhttprequest.readyState==4) {
                    if(xmlhttprequest.status==200) {
                    var data = xmlhttprequest.responseText;
                        if(data=="true") {
                            msg.innerText = "该用户名已存在";
                        }
                        else {
                            msg.innerHTML = "注册成功";
                        }
                    }
               }
               else {
                   msg.innerText = "请稍后";
               }
            }
        </script> --%>

        <script type = "text/javascript">
            //定义文档就绪
            $(document).ready(function () {
                checkuser();
            });

            function checkuser() {
                $("#username").blur(function () {
                    var msg = document.getElementById("msg");
                    var username = document.getElementById("username");

                    if(username.value=="") {
                        msg.innerText = "用户名不能为空！";
                        username.focus();//focus()表示输入框获得焦点
                        return;
                    }

                    var url = "userServlet";
                    var param = "username="+encodeURIComponent(username.value);

                    // $.ajax({
                    //     url:url,
                    //     data:param,
                    //     success:function (data, status) {
                    //         callBack(data, status);
                    //     }
                    // })

                    $.post(url,param, function (data, status) {
                        callBack(data, status);
                    })
                })
            }

            function callBack(data, status) {
                var msg = document.getElementById("msg");
                if("success" == status) {
                    if("true" == data) {
                        msg.innerText = "该用户已存在";
                    }
                    else if("false" == data) {
                        msg.innerText = "注册成功！";
                    }
                }
            }
        </script>
    </head>
    <body>
        <h2>HelloWorld!</h2>

        <%-- 用户名：<input type = "text" id = "username" name = "username" onblur = "checkuser()"><span id = "sp"></span> --%>

        用户名：<input type = "text" name = "username" id = "username"><span id = "msg"></span>
    </body>
</html>
