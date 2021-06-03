<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/17 0017
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="fileUpload.do" method="post" enctype="multipart/form-data">
        文件<input type="file" name="myFile"><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
