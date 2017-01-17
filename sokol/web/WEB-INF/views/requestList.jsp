    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>


    <script type="text/javascript">
        function confirmAction(id) {
            if (confirm("Вы действительно хотите удалить запрос № " + id + " ?")) {
                return true;
            } else {
                return false;
            }
        }
    </script>

    <c:url var="root_url" value="/"/>
    <div class="container">
        <div class="table-header">
            <a href="${root_url}requestList/add?pagenumber=${pagenumber}&sortBy=${sortBy}&sortOrder=${sortOrder}&sortOrderHeader=${sortOrderHeader}" class="create-btn btn-danger">НОВЫЙ</a>


            <div style="display: inline-block; width: 300px; float: right; margin-top: -5px;">
                <%--<form role="search">--%>
                    <div class="input-group" >
                        <input type="text" class="form-control" placeholder="Поиск">
                        <div class="input-group-btn">
                            <a class="btn btn-default" title="Поиск" href="/requestList/add" role="button">
                                <i class="glyphicon glyphicon-search"></i>
                            </a>
                        </div>
                    </div>
                <%--</form>--%>
            </div>

            <%--<div style="display: inline-block; width: 300px; float: right; margin-top: -5px;">--%>
            <%--<div class="input-group">--%>
            <%--<input type="text" class="form-control" placeholder="Поиск">--%>
            <%--<div class="input-group-btn">--%>
            <%--<button class="btn btn-default" type="submit">--%>
            <%--<i class="glyphicon glyphicon-search"></i>--%>
            <%--</button>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>

        <div class="table-wrapper">
            <table class="list-table">
                <thead>

                <th style="width: 3%">#</th>
                <th style="width: 8%">
                    <%--<c:if test="${sortBy.equals('status')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=status&sortOrder=${sortOrderHeader}" class="sort-up">СТАТУС</a>
                </th>
                <th style="width: 14%">
                    <%--<c:if test="${sortBy.equals('title')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=title&sortOrder=${sortOrderHeader}">НАЗВАНИЕ</a>
                </th>
                <th style="width: 14%">
                    <%--<c:if test="${sortBy.equals('description')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=description&sortOrder=${sortOrderHeader}">ОПИСАНИЕ</a>
                </th>
                <th style="width: 8%">
                    <%--<c:if test="${sortBy.equals('createdBy')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=createdBy&sortOrder=${sortOrderHeader}">СОЗДАТЕЛЬ</a>
                </th>
                <th style="width: 10%">
                    <%--<c:if test="${sortBy.equals('assignedTo')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=assignedTo&sortOrder=${sortOrderHeader}">ИСПОЛНИТЕЛЬ</a>
                </th>
                <th style="width: 10%">
                    <%--<c:if test="${sortBy.equals('department')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=department&sortOrder=${sortOrderHeader}">ДЕПАРТАМЕНТ</a>
                </th>
                <th style="width: 8%">
                    <%--<c:if test="${sortBy.equals('requestType')}">--%>
                        <%--<img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>--%>
                    <%--</c:if>--%>
                    <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=requestType&sortOrder=${sortOrderHeader}">ТИП</a>
                </th>
                <th style="width: 5%">УДАЛИТЬ</th>

                </thead>
                <tbody>
                <c:forEach items="${requestAll}" var="lists" step="1" varStatus="loopStatus">

                    <tr class="${loopStatus.index % 2 == 0 ? 'alt' : ''}">

                        <td>  <c:out value="${lists.requestId}"/></td>
                        <td>  <c:out value="${lists.status.requestStatusName}"/></td>
                        <td>
                            <a title="Редактирование запроса"
                               href="/requestList/edit?idRequest=${lists.requestId}&pagenumber=${pagenumber}&sortBy=${sortBy}&sortOrder=${sortOrder}&sortOrderHeader=${sortOrderHeader}">
                                <c:out value="${lists.title}"/>
                            </a>
                        </td>

                        <td>  <c:out value="${lists.description}"/></td>
                        <td>  <c:out value="${lists.createdBy}"/></td>
                        <td>  <c:out value="${lists.assignedTo.fio}"/></td>
                        <td>  <c:out value="${lists.department.title}"/></td>
                        <td>  <c:out value="${lists.requestType.title}"/></td>
                        <%--<td>  <a class="btn btn-default" title="Удаление запроса"--%>
                                 <%--href="/requestList/delete?idRequest=${lists.requestId}"--%>
                                 <%--onclick="return confirmAction(${lists.requestId})"--%>
                                 <%--role="button">--%>
                            <%--<img src="/img/TrashFull.png" hspace="5" border="0"> </img>--%>
                        <%--</a>--%>
                        <%----%>
                        <%--</td>--%>
                        <td class="del-cell"><a class="del-btn" href="#" onclick="return confirmAction(${lists.requestId})"></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="table-footer">
                <table>
                    <tr>
                        <td>Страницы:</td>
                        <td>
                            <ul class="pagination">
                                <li>
                                    <a href="" aria-label="Previous"><span aria-hidden="true">&laquo</span></a>
                                </li>
                                <c:forEach items="${pageTotal}" var="pagenumber" step="1">
                                    <li>
                                        <a href="/requestList/list?pagenumber=${pagenumber.intValue()}&sortBy=${sortBy}&sortOrder=${sortOrder}">
                                            <c:out value="${pagenumber.intValue()}"/>
                                        </a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <a href="" aria-label="Previous"><span aria-hidden="true">&raquo</span></a>
                                </li>
                            </ul>

                        </td>
                    </tr>
                </table>
            </div>
        </div>

    </div>

