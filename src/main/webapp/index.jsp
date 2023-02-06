<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/3
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            let address = $("#address");
            let sheng = "";
            let shi = "";
            let qu = "";
            // 1. ajax pid = 0
            getCityByPid(0,'#sheng')
            // 2. ajax
            $("#sheng").change(function (){
                let id = $("#sheng").val();
                getCityByPid(id,'#shi');
                sheng = $("#sheng option:selected").text();
                address.val(sheng);
                $("#shi").empty();
                $("#qu").empty();
            });
            // 3. ajax
            $("#shi").change(function (){
                let id = $(this).val();
                getCityByPid(id,'#qu');
                shi = $("#shi option:selected").text();
                address.val(sheng+shi);
                $("#qu").empty();
            });

            $("#qu").change(function (){
                qu = $("#qu option:selected").text();
                address.val(sheng+shi+qu);
            });
        });

        function getCityByPid(pid,area){
            $.ajax({
                url:"<%=request.getContextPath()%>/demo?m=getCityByPid",
                data:{pid:pid},
                type:"post",
                dataType:"json",
                success:function (obj){
                    $(area).append("<option>请选择</option>");
                    for(let c of obj){
                        $(area).append("<option value="+c.id+">"+c.name+"</option>");
                    }
                }
            });
        }
    </script>
</head>
<body>
<input type="text" id="address"><br>
<select id="sheng"></select>省
<select id="shi"></select>市
<select id="qu"></select>区

</body>
</html>
