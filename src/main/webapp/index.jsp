<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> Hej ${requestScope.login}
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="login.jsp">Login side</a>
</body>
</html>