<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/2
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $(".update").click(function (){
                let id = $(this).next().val();
                location = "demo/update.jsp?id="+id;
            });
            $(function (){
                $(".dalete").click(function () {
                    let id = $(this).prev().val();
                    $.ajax({
                        url:"<%=request.getContextPath()%>/demo?m=delete&id="+id,
                        dataType:"json",
                        success:function (obj){
                        if (obj){
                            location.reload();
                        }
                        }
                    });
                });
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>爱好</td>
        <td>类型</td>
        <td>
            操作 | <input type="button" value="添加" id="add">
        </td>
    </tr>
    <c:forEach items="${u}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.sex}</td>
            <td>${u.age}</td>
            <td>${u.hobby}</td>
            <td>${u.type.name}</td>
            <td>
                <input type="button" value="修改" class="update">
                <input type="hidden" value="${u.id}">
                <input type="button" value="删除" class="dalete">
            </td>
        </tr>
    </c:forEach>
</table>
</body>

        <script>
            //获取id 是add的元素
            let add = document.getElementById("add")
            //绑定点击事件
            add.onclick = function (){
                location = "demo/add.jsp"
            }
        </script>
</html>
