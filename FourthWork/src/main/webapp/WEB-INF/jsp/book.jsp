<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <head>
        <title>主页</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            #all {
                width: 99%;
            }
            .form-inline {
                overflow: hidden;
                text-align: center;
                font-weight: bold;
            }
            .btn {
                float: right;                
            }
            #add {
                display: none;
            }
        </style>

        <script>
            function deleteBook(id) {
                if(confirm("确定要删除编号为"+id+"的书籍吗？")) {
                    var url = "${BASE_PATH}/book/deleteBook";

                    $.post(url, {id:id}, function(data,status) {
                        deleteall(data,status);
                    })
                }
            }
            function deleteall(data,status) {
                if("success" == status) {
                    if(data == "success") {
                        alert("删除成功！");

                        window.location.reload();
                    }
                    else {
                        alert("删除失败！请重新操作");
                    }
                }
            }

            function getInfo(id,bookname,bookauthor,bookdes) {
                document.getElementById("id1").value = id;
                document.getElementById("bookname1").value = bookname;
                document.getElementById("bookauthor1").value = bookauthor;
                document.getElementById("bookdes1").value = bookdes;
            }

        
            function updateBook() {
                var id = document.getElementById("id1").value;
                var bookname = document.getElementById("bookname1").value;
                var bookauthor = document.getElementById("bookauthor1").value;
                var bookdes = document.getElementById("bookdes1").value;

                if(confirm("确定要修改编号为"+id+"的书籍信息吗？") == true){
                    var url="${BASE_PATH}/book/updateBook";

                    $.post(url,{id:id,bookname:bookname,bookauthor:bookauthor,bookdes:bookdes},function (data,status) {
                        updateAll(data,status);
                    });
                }
            }

            function updateAll(data,status) {
                if("success" == status){
                    if(data == "success"){
                        alert("修改成功！");

                        window.location.reload();
                    }else{
                        alert("修改失败！请重试");
                    }
                }
            }

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
        <div id = "all">
            <table class="table table-bordered table-hover">
                <caption style="text-align: center">
                    <form class = "form-inline" action = "${BASE_PATH}/book/findBook" method = "post">
                        <span>书籍信息表</span>
                        <div class = "btn">
                            <input class = "form-control" type = "text" placeholder = "请输入书籍名称" name = "bookname">
                            <button type = "submit" class = "btn btn-default">搜索</button>
                        </div>
                    </form>
                    <button class="btn btn-primary btn-sm" style = "width:100px" data-toggle="modal" href="#example2">
                        添加图书
                    </button>
                </caption>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>简介</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="book">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.bookname}</td>
                            <td>${book.bookauthor}</td>
                            <td>${book.bookdes}</td>
                            <td>
                                <button class="btn btn-primary btn-sm" data-toggle="modal" href="#example1" data-target="#myModal" onclick="getInfo(${book.id},'${book.bookname}','${book.bookauthor}','${book.bookdes}')">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                    修改
                                </button>
                            </td>
                            <td>
                                <button class="btn btn-danger btn-sm" onclick="deleteBook(${book.id})">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                    删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-6">
                    第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
                </div>
                <div class="col-md-6 offset-md-4" style="text-align: right">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-sm">
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/book/listBook?page=1"
                                                    href="${BASE_PATH}/book/findBook?page=1">首页</a></li>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                <c:if test="${page==pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                </c:if>
                                <c:if test="${page!=pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                            href="${BASE_PATH}/book/listBook?page=${page}"
                                                            href="${BASE_PATH}/book/findBook?page=${page}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li class="page-item"><a class="page-link"
                                                        href="${BASE_PATH}/book/listBook?page=${pageInfo.pageNum+1}"
                                                        href="${BASE_PATH}/book/findBook?page=${pageInfo.pageNum+1}">下一页</a></li>
                            </c:if>
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/book/listBook?page=${pageInfo.pages}"
                                                                        href="${BASE_PATH}/book/findBook?page=${pageInfo.pages}">末页</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div id = "example1">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    修改书籍信息
                                </h4>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="id1">
                                <div class="input-group">
                                    <span class="input-group-addon">书名</span>
                                    <input id="bookname1" name="bookname1" type="text" class="form-control">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon">作者</span>
                                    <input id="bookauthor1" name="bookauthor1" type="text" class="form-control">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon">简介</span>
                                    <input id="bookdes1" name="bookdes1" type="text" class="form-control">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" onclick="updateBook()">
                                    确认修改
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="example2" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                添加图书
                            </h4>
                        </div>
                        <form action = "${BASE_PATH}/book/addBook" method="post" onsubmit="validSub()">
                            <div class="modal-body">
                                <div class="input-group">
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
                            </div>
                            <div class="modal-footer">
                                <input class="btn btn-primary btn-lg btn-block" type="submit" value="添加">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
