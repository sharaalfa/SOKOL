<%--
  User: Mikhail Bedritskiy
  Date: 09.10.2016
  Time: 20:31
--%>

<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>RequestTypeForm</title>
</head>
<body>
<h1>Request Type</h1>
<sf:form method="post" commandName="requestType">
    Title: <sf:input path="title"/><br/>
    Description: <sf:input path="description"/><br/>
    <input type="submit" value="Register"/>
    <a class="btn btn-danger" href="${cancelUrl}">Cancel</a>
</sf:form>
</body>
</html>
