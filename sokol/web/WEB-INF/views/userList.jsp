<%--
  Created by IntelliJ IDEA.
  User: denspbru
  Date: 13.11.16
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Список сотрудников</h2>

<table>
    <tr>
        <th>#</th>
        <th>Логин</th>
        <th>ФИО</th>
        <th>Эл. почта</th>
        <%--<th>Подразделение</th>--%>
    </tr>
<c:forEach items="${userList}" var="user" step="1">
    <tr class="row2">
        <td><c:out value="${user.id}"/></td>
        <td><a href="/users/${user.id}"> <c:out value="${user.login}"/></a></td>
        <td><c:out value="${user.fio}"/></td>
        <td><c:out value="${user.email}"/></td>
        <%--<td><c:out value="${user.department.title}"/></td>--%>
    </tr>
</c:forEach>
</table>
