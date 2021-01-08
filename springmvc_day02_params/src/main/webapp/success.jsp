<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取请求参数成功</h1>
    <h1><%=request.getAttribute("name")%></h1>
    <h1>${requestScope.name}</h1>

    <hr/>
    <h1>${requestScope.user.username}</h1>
    <h1>${requestScope.user1.username}</h1>
</body>
</html>
