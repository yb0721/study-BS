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
    
        <script type = "text/javascript">
            function deleteDept(dno) {
                if(confirm("确定要删除编号为【"+dno+"】的部门吗？")==true){
                    var url="${BASE_PATH}/dept/deleteDept";

                    $.post(url,{dno:dno},function (data,status) {
                        deleteDeptcallback(data,status);
                    });
                }
            }
            function deleteDeptcallback(data,status) {
                if("success"==status){
                    if(data=="success"){
                    alert("删除成功！");
                    
                    //reload:刷新，重新加载页面
                    window.location.reload();
                    }else{
                        alert("删除失败！请重试或联系管理员！");
                    }
                }
            }
            function getInfo(dno,dname,loc) {
                // alert(dno);
                document.getElementById("dno1").value=dno;
                document.getElementById("dname1").value=dname;
                document.getElementById("loc1").value=loc;
            }

        
            function updateDept() {
                var dno=document.getElementById("dno1").value;
                var dname=document.getElementById("dname1").value;
                var loc=document.getElementById("loc1").value;

                if(confirm("确定要修改编号为【"+dno+"】的部门吗？")==true){
                    var url="${BASE_PATH}/dept/updateDept";

                    $.post(url,{dno:dno,dname:dname,loc:loc},function (data,status) {
                        updateDeptcallback(data,status);
                    });
                }
            }

            function updateDeptcallback(data,status) {
                if("success"==status){
                    if(data=="success"){
                        alert("修改成功！");
                        window.location.reload();reload：刷新，重新加载
                    }else{
                        alert("修改失败！请重试或联系管理员！");
                    }
                }
            }

            function validSub() {
            var dname=document.getElementById("dname").value;
            var loc=document.getElementById("loc").value;

            if(dname==""){
                alert("部门名称不能为空！");
                return false;
            }
            if(loc==""){
                alert("部门地址不能为空！");
                return false;
            }
            return true;
        }
        </script>
    </head>

    <body>
        ${sessionScope.user.uname}:登录成功！
        <div style="margin: auto;width: 800px;">
            <table class="table table-bordered table-hover">
                <caption style="text-align: center">部门信息表</caption>
                <thead>
                <tr>
                    <th>部门id</th>
                    <th>部门名称</th>
                    <th>部门地址</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${pageInfo.list}" var="dept">
                    <tr>
                        <td>${dept.dno}</td>
                        <td>${dept.dname}</td>
                        <td>${dept.loc}</td>
                        <td>
                            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="getInfo(${dept.dno},'${dept.dname}','${dept.loc}')">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                修改
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-danger btn-sm" onclick="deleteDept(${dept.dno})">
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
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/dept/listDept?page=1">首页</a></li>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                <c:if test="${page==pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                </c:if>
                                <c:if test="${page!=pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                            href="${BASE_PATH}/dept/listDept?page=${page}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li class="page-item"><a class="page-link"
                                                        href="${BASE_PATH}/dept/listDept?page=${pageInfo.pageNum+1}">下一页</a></li>
                            </c:if>
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/dept/listDept?page=${pageInfo.pages}">末页</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div style="width: 500px;">
                <form action="${BASE_PATH}/dept/addDept" method="post" onsubmit="validSub()">
                    <div class="input-group">
                        <span class="input-group-addon">部门名称</span>
                        <input id="dname" name="dname" type="text" class="form-control" placeholder="请输入用户名">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">部门地址</span>
                        <input id="loc" name="loc" type="text" class="form-control" placeholder="请输入部门地址">
                    </div>
                    <input class="btn btn-primary btn-lg btn-block" type="submit" value="添加">
                </form>
            </div>
        </div>
    </body>
</html>