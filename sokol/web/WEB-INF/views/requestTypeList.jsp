<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    function confirm_delete(type_id) {
        if (confirm("you want to delete the user?")) {
            window.location = "/requestType/" + type_id + "/delete";
        } else {
            return false;
        }
        return true;
    }
</script>

<div class="panel panel-default">
    <div class="panel-heading">СОКОЛ</div>
    <div class="panel-body">List of Request Types</div>
</div>

<br/>
<a class="btn btn-success" href="/requestType/add">NEW</a>
<br/>
<table>
    <tr>
        <th style="width: 3%">X</th>
        <th style="width: 3%">?</th>
        <th style="width: 5%">id</th>
        <th style="width: 20%">Название</th>
        <th style="width: 45%">Описание</th>

        <th style="width: 10%">Создано</th>
        <th style="width: 10%">Обновлено</th>
    </tr>

    <c:forEach items="${requestTypes}" var="list" step="1">
        <tr class="row2">
            <td><input type="submit" name="delete" value="delete"
                       onclick="return confirm_delete(${list.id})"/></td>
                <%--<td><a href="/requestType/${list.id}/delete"> X </a></td>--%>
            <td><a href="/requestType/${list.id}"> ? </a></td>
            <td><c:out value="${list.id}"/> </a></td>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.description}"/></td>
            <td><c:out value="${list.createdDate}"/></td>
            <td><c:out value="${list.updatedDate}"/></td>
        </tr>
    </c:forEach>

</table>
