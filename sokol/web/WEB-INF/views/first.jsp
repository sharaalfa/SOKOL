
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form method="post" modelAttribute="user" action="second">
        Name: <spring:input path="name"/><br/>
        Email: <spring:input path="email"/><br/>
        <spring:button>Next Page</spring:button>
    </spring:form>
</body>
</html>
