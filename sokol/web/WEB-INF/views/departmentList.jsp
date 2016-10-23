<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Departments</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css"
          rel="stylesheet">
</head>

<body>
<script type="text/javascript">
    function confirm_delete(id) {
        if (confirm("you want to delete the user?")) {
            window.location = "/department/delete/" + id ;
        } else {
            return false;
        }
        return true;
    }
</script>

<div class="panel panel-default">
    <div class="panel-heading">СОКОЛ</div>
    <div class="panel-body">List of Departments</div>
</div>

<br/>
<a class="btn btn-success" href="/department/add">NEW</a>
<br/>
<table>
    <tr>
        <th style="width: 5%">X</th>
        <th style="width: 5%">?</th>
        <th style="width: 5%">id</th>
        <th style="width: 30%">Название</th>
        <th style="width: 10%">Создано</th>
        <th style="width: 10%">Обновлено</th>
    </tr>

    <c:forEach items="${departmentList}" var="list" step="1">
        <tr class="row2">
            <td>
                <input type="submit" name="delete" value=" X " onclick="return confirm_delete(${list.id})"/>
            </td>
            <td><a href="/department/${list.id}"> ? </a></td>
            <td><c:out value="${list.id}"/> </a></td>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.createdDate}"/></td>
            <td><c:out value="${list.updatedDate}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
