    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

        <title>Request</title>
        <!-- Bootstrap -->

        <script type="text/javascript">
            function confirmAction(id) {
                if (confirm("Вы действительно хотите удалить запрос № " + id + " ?")) {
                    return true;
                } else {
                   return false;
                }
            }
        </script>

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
        <div class="panel panel-default">
        <div class="panel panel-default">
    <div class="panel-body">
       <a class="btn btn-default" title="Добавление запроса" href="/requestList/add"
          role="button"><span class="glyphicon glyphicon-plus"></span>
       </a>
       Список запросов
    </div>

    <table>
         <tr>
             <th style="width: 3%">№</th>
             <th style="width: 8%">Статус</th>
             <th style="width: 16%">Название</th>
             <th style="width: 16%">Описание</th>
             <th style="width: 8%">Создатель</th>
             <th style="width: 8%">Исполнитель</th>
             <th style="width: 8%">Департамент</th>
             <th style="width: 8%">Тип</th>
             <th style="width: 8%">Создано</th>
             <th style="width: 8%">Обновлено</th>
             <th style="width: 5%"></th>
         </tr>

        <c:forEach items="${requestAll}" var="lists" step="1">
             <tr class="row2">
                <td>  <c:out value="${lists.requestId}"/></td>
                <td>  <c:out value="${lists.status.requestStatusName}"/></td>
                 <td>
                     <a title="Редактирование запроса"
                        href="/requestEdit?idRequest=${lists.requestId}">
                        <c:out value="${lists.title}"/>
                     </a>
                 </td>
                 <td>  <c:out value="${lists.description}"/></td>
                 <td>  <c:out value="${lists.createdBy}"/></td>
                 <td>  <c:out value="${lists.assignedTo.fio}"/></td>
                 <td>  <c:out value="${lists.department.title}"/></td>
                 <td>  <c:out value="${lists.requestType.title}"/></td>
                 <td>  <c:out value="${lists.createdDate}"/></td>
                 <td>  <c:out value="${lists.updatedDate}"/></td>
                 <td>  <a class="btn btn-default" title="Удаление запроса"
                          href="/requestList/delete?idRequest=${lists.requestId}"
                          onclick="return confirmAction(${lists.requestId})"
                          role="button">
                          <span class="glyphicon glyphicon-remove"></span>
                       </a>
                 </td>
             </tr>
         </c:forEach>
    </table>

