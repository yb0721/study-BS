<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <head>
        <title>添加书籍</title>

        <script>
            function validSub() {
                var bookname = document.getElementById("bookname").value;
                var bookauthor = document.getElementById("bookauthor").value;
                var bookdes = document.getElementById("bookdes").value;

                if(bookname == ""){
                    alert("请填写书籍名称！");
                    return false;
                }
                else if(bookauthor == ""){
                    alert("请填写作者！");
                    return false;
                }
                else if(bookdes == "") {
                    alert("请填写书籍简介");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div style="width: 500px;" id = "add">
            <form action = "${BASE_PATH}/book/addBook" method="post" onsubmit="validSub()">
                <div class = "input-group">
                    <span class = "input-group-addon">书名</span>
                    <input id = "bookname" name = "bookname" type="text" class="form-control">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input id = "bookauthor" name = "bookauthor" type="text" class="form-control">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">简介</span>
                    <input id = "bookdes" name = "bookdes" type="text" class="form-control">
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="添加">
            </form>
        </div>
    </body>
</html>