<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> Intranet for 2. semester hold B
</h1>
<c:if test="${sessionScope.user == null}">
    <p>Du kan logge på her: <a href="login.jsp">Login</a> </p>
</c:if>

<c:if test ="${sessionScope.user != null}"></c:if>
Status på log: ${requestScope.message}
<p>${sessionScope.user.login}</p>
<p><a href="/classlist">/p> //TJEK OP PÅ DET
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="login.jsp">Login side</a>
</body>
</html>