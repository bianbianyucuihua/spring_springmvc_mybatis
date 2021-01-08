<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2020/11/16
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="user/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
    <hr/>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        <input type="file" name="files" multiple="multiple">
        <input type="submit" value="上传">
    </form>
</body>
</html>
