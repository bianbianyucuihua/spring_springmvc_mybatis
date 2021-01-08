<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
    <script>
        function sendJson() {
            $.ajax({
                url:"user/getJson3",
                contentType:"application/json",
                type:"POST",
                data:'{"id":10,"name":"张三","age":18}',
                success:function (msg) {
                    console.log(msg);
                    console.log(msg.u1.name);
                }
            })
        }
    </script>
</head>
<body>
    <a href="javascript:void(0);" onclick="sendJson();">通过ajax异步发送JSON到JSONController</a>
    <a href="http://localhost:9999/image_files_war/">访问files服务器</a>
</body>
</html>
