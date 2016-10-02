<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>erferferferferf</p>
<table>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
</tr>
<c:forEach var="reqType" items="${requestTypes}" step="1">
    <tr>
        <td>${reqType.id}</td>
        <td>${reqType.title}</td>
        <td>${reqType.description}</td>
    </tr>
</c:forEach>
</table>
