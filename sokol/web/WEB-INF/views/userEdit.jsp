<%--
  Created by IntelliJ IDEA.
  User: denspbru
  Date: 13.11.16
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Сотрудник</h2>

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>
<sf:form method="post" action="/users/${user.id}">
    <div class="row" style="margin: 10px;">
        <div class="col-md-8">
            <div class="form-group">
                <label for="inputLogin">Логин</label>
                <input name="login" id="inputLogin" class="form-control" placeholder="Имя пользователя" value="${user.login}" required autofocus/>
            </div>
            <div class="form-group">
                <label for="inputFio">ФИО сотрудника</label>
                <input name="fio" id="inputFio" class="form-control" placeholder="ФИО сотрудника" value="${user.fio}" required />
            </div>
            <div class="form-group">
                <label for="inputEmail">Эл. почта</label>
                <input name="email" id="inputEmail" class="form-control" placeholder="Эл. почта." value="${user.email}" required />
            </div>
            <div class="form-group">
                <label for="inputEmail">Пароль</label>
                <input name="password" type="password" id="inputPassoword" class="form-control" placeholder="Пароль" value="12345" required />
            </div>
            <div class="form-group">
                <label for="inputConfirmPassword">Подтверждение пароля</label>
                <input name="confirmPassword" type="password" id="inputConfirmPassword" class="form-control" placeholder="Подтверждение пароля" value="" required />
            </div>
            <div class="form-group">
                <div class="form-group">
                    <label for="roleId">Роль</label>
                    <select name="roleId" class="form-control" id="roleId">
                        <c:forEach var="role" items="${roles}">
                            <c:choose>
                                <c:when test="${role.id == user.role.id}">
                                    <option value="${role.id}" selected="1">${role.description}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${role.id}">${role.description}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputDepartmen">Подразделение</label>
                <select name="departmentId"  class="form-control" id="inputDepartmen">
                    <c:forEach var="department" items="${departments}">
                        <c:choose>
                            <c:when test="${department.id == user.department.id}">
                                <option value="${department.id}" selected="1">${department.title}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${department.id}">${department.title}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="row">
                <div class="pull-right">
                    <button class="btn btn-primary" style="margin: 5px;" type="submit">Сохранить</button>
                    <button class="btn btn-danger"  style="margin: 5px;" onclick="document.location = '/users/list'; return false;">Cancel</button>
                </div>
            </div>

        </div>
    </div>

</sf:form>