<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2020/11/16
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
    <script>
        function sendJSON() {
            $.ajax({
                url:"getJSONData",
                contentType:"application/json",
                type:'POST',
                data:'{"username":"张三","age":20}',
                success:function (msg) {

                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="sendJSON();" value="ajax异步发送数据"/>
</body>
</html>
