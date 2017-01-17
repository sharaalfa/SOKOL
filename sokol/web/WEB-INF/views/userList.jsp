<%--
  Created by IntelliJ IDEA.
  User: denspbru
  Date: 13.11.16
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="root_url" value="/"/>
<div class="container">
<div class="table-header">
    <a href="${root_url}users/create" class="create-btn btn-danger">НОВЫЙ</a>

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
        <th>#</th>
        <th>Логин</th>
        <th>ФИО</th>
        <th>Эл. почта</th>
        <th>УДАЛИТЬ</th>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user" step="1" varStatus="loopStatus">
            <tr class="${loopStatus.index % 2 == 0 ? 'alt' : ''}">
                <td><c:out value="${user.id}"/></td>
                <td><a href="/users/${user.id}"> <c:out value="${user.login}"/></a></td>
                <td><c:out value="${user.fio}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td class="del-cell"><a class="del-btn" href="#"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="table-footer">

        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>Страницы:</td>--%>
                <%--<td>--%>
                    <%--<ul class="pagination">--%>
                        <%--<li>--%>
                            <%--<a href="" aria-label="Previous"><span aria-hidden="true">«</span></a>--%>
                        <%--</li>--%>

                        <%--<li>--%>
                            <%--<a href="#">1</a>--%>
                        <%--</li>--%>

                        <%--<li>--%>
                            <%--<a href="#">2</a>--%>
                        <%--</li>--%>

                        <%--<li>--%>
                            <%--<a href="" aria-label="Previous"><span aria-hidden="true">»</span></a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>

    </div>
</div>
</div>
