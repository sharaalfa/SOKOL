<%--
  User: Mikhail Bedritskiy
  Date: 09.11.2016
  Time: 20:31
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Request Type</h1>
<sf:form method="post" commandName="requestType">
    Title: <sf:input path="title"/><br/>
    Description: <sf:input path="description"/><br/>
    Responsibility:
    <sf:select  path="department" items="${departments}" >
        <c:forEach items="${departments}" var="departmentList">
            <option value="${departmentList.id}"><c:out value="${departmentList.title}"/> </option>
        </c:forEach>
    </sf:select>
    <br/>
    <input type="submit" value="Register"/>
    <a class="btn btn-danger" href="${cancelUrl}">Cancel</a>
</sf:form>
