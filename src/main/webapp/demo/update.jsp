<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/2
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        const id = ${param.id};
        $(function (){
            $(function (){
                $.ajax({
                    //发送请求的路径
                    url:"../demo",
                    //传送的数据
                    data:{m:"getType"},
                    //提交请求的类型、方式 post/get   默认get
                    type:"post",
                    //预期服务器返回数据的类型  默认texe  json
                    dataType:"json",
                    //成功时的回调函数
                    success:function (obj){
                        let select = $("#sid")
                        for (let type of obj){
                            let option = "<option value='"+type.sid+"'>"+type.name+"</option>";
                            select.append(option)
                        }
                    },
                    async:false
                })



              $.ajax({
                  url:'../demo',
                  data:{id:id,m:"queryById"},
                  type:"post",
                  dataType:"json",
                  success:function (obj){
                      $("#id").val(obj.id);
                      $("#name").val(obj.name);
                      $("#sex").val(obj.sex);
                      $("#age").val(obj.age);
                      $("#hobby").val(obj.hobby);
                      $("#sid").val(obj.type.sid);
                      $(".sex[value="+obj.sex+"]").attr("checked",true);
                  },
                  async:false
              });
            });




            $("#btn").click(function (){
                $.ajax({
                    url: "../demo?m=update",
                    data: $("#f").serialize(),
                    type: "post",
                    dataType: "json",
                    success:function (obj){
                        if (obj){
                            location = "../demo?m=query"
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<form id="f">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input type="hidden" name="id" id="id">
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" class="sex" value="雄">雄
                <input type="radio" name="sex" class="sex" value="雌">雌
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age">
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="text" name="hobby" id="hobby">
            </td>
        </tr>
        <tr>
            <td>类别</td>
            <td>
                <select name="sid" id="sid">
                    <option>请选择</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="修改" id="btn">
            </td>
        </tr>
    </table>
</form>\
</body>
</html>
