<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 9/8/2019
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data">
        <input type="file" name="photo">
        <input type="submit" value="提交">
    </form>
</body>
</html>
