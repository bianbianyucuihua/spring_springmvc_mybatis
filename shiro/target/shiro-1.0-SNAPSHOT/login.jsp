<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2020/12/2
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/sys/user/login" method="post">
        用户名：<input type="text" name="username" /><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
