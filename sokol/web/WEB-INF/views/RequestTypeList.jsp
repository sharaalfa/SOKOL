<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>Request</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css"
          rel="stylesheet">
</head>


<body>

<style>
    table {
        width: 100%;
    }

    th {
        font-size: 13px;
        font-weight: normal;
        background: #b9c9fe;
        border-top: 4px solid #aabcfe;
        border-bottom: 1px solid #fff;
        color: #039;
        padding: 8px;
    }

    td {
        background: #e8edff;
        border-bottom: 1px solid #fff;
        color: #669;
        border-top: 1px solid transparent;
        padding: 8px;
    }

    tr:hover td {
        background: #ccddff;
    }
</style>

<div class="panel panel-default">
    <div class="panel-heading">СОКОЛ</div>
    <div class="panel-body">Список запросов</div>
</div>

<table>
    <tr>
        <th style="width: 3%">id</th>
        <th style="width: 20%">Название</th>
        <th style="width: 45%">Описание</th>

        <th style="width: 8%">Создано</th>
        <th style="width: 8%">Обновлено</th>
    </tr>

    <c:forEach items="${requestTypeList}" var="list" step="1">
        <tr class="row2">
            <td><a href="/editRequestType?id=${list.id}"> <c:out value="${list.id}"/> </a>
            </td>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.description}"/></td>
            <td><c:out value="${list.createdDate}"/></td>
            <td><c:out value="${list.updatedDate}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
