<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2020/11/17
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>传统的上传文件</h1>
    <form method="post" enctype="multipart/form-data" action="fileupload">
        <input type="text" name="name"><br/>
        <input type="file" name="file"><br/>
        <input type="submit" value="上传">
    </form>
    <h1>SpringMVC上传文件</h1>
    <form method="post" enctype="multipart/form-data" action="fileupload2">
        <input type="text" name="name"><br/>
        <input type="file" name="file"><br/>
        <input type="submit" value="上传">
    </form>
    <h1>SpringMVC批量上传文件</h1>
    <form method="post" enctype="multipart/form-data" action="fileupload3">
        <input type="text" name="name"><br/>
        <input type="file" name="files" multiple="multiple"><br/>
        <input type="submit" value="上传">
    </form>
    <h1>SpringMVC跨域上传文件</h1>
    <form method="post" enctype="multipart/form-data" action="fileupload4">
        <input type="text" name="name"><br/>
        <input type="file" name="files" multiple="multiple"><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
