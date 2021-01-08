<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="user/request1">测试环境搭建是否成功</a>
    <a href="user/request2?name=admin">传统获取参数name</a>
    <a href="user/request3?name=zhangsan&age=20">参数名映射获取</a>
    <hr/>
    <form method="post" action="user/request4">
        用户名：<input type="text" name="username"><br/>
        电话号码：<input type="text" name="phone"><br/>
        年龄：<input type="text" name="age"><br/>
        性别：<input type="radio" name="gender" value="male">
        <input type="radio" name="gender" value="female"><br/>
        爱好：足球<input type="checkbox" name="hobby" value="football">
        篮球<input type="checkbox" name="hobby" value="basketball">
        乒乓球<input type="checkbox" name="hobby" value="pingpong"><br/>
        出生日期：<input type="date" name="birthday"/><br/>
        工资:<input type="text" name="account.money">
        <input type="submit" value="提交">
    </form>
    <hr/>
    <a href="user/request5?name=admin">注解获取参数name</a>
    <hr/>
    <a href="user/request6/007">注解获取参数name</a>
    <hr/>
    <form method="post" action="user/request7">
        用户名：<input type="text" name="username"><br/>
        电话号码：<input type="text" name="phone"><br/>
        <input type="submit" value="提交">
    </form>
    <hr/>
    <a href="user/goJSON">去json格式传递参数的页面</a>
</body>
</html>
