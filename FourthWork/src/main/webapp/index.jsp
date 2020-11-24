<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <head>
        <title>图书管理系统</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            #all {
                padding-top: 10%;
                margin: 0 auto;
	            width: 20%;
            }
            form div {
                width: 300px;
            }
            #Reg {
                margin-left: 19%;
                margin-top: -16%;
            }
            p {
	            text-align: center;
            }
        </style>

        <script language = "JavaScript" type = "text/JavaScript">
            function check(form) {
                var username = form.username.value;
                if(username.length == 0){
                    alert("用户名不能为空！");
                    form.username.focus();
                    return false;
                }
                var password = form.password.value;
                if(password.length == 0) {
                    alert("密码不能为空！");
                    form.password.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id = "all">
            <p>
                <svg class="bi bi-person-lines-fill" width="3em" height="3em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm7 1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm-2-3a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm2 9a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z"/>
                </svg>
            </p>
            <form action = "${BASE_PATH}/user/login" method = "post" onSubmit = "return check(this)">
                <div class="form-group">
                    <label for="exampleInputText1">Username</label>
                    <input type="text" class="form-control" id="exampleInput1" aria-describedby="textHelp" name = "username">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name = "password">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <button class="btn btn-link btn-lg" data-toggle="modal" data-target="#myModal" id = "Reg">
                Reg
            </button>
        </div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <form action="${BASE_PATH}/user/reg" method="post" onSubmit = "return check(this)">
                            <div class="input-group">
                                <span class="input-group-addon">Username</span>
                                <input name="username" type="text" class="form-control" style = "width: 350px;">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">Password</span>
                                <input name="password" type="password" class="form-control" style = "width: 350px;">
                            </div>
                            <input class="btn btn-primary btn-sm .btn-default" type="submit" value="Reg" style = "width: 450px; margin-top: 5px">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
