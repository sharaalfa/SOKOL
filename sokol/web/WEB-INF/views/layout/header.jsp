<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="user" property="principal" />

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <p class="navbar-text navbar-right">

            <sec:authorize access="isAnonymous()">
                <a class="btn-sm btn-info" href="/login">Войти</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                Вы вошли как <b style="padding-right: 10px;"> ${user.getUsername()}</b>
                <a class="btn-sm btn-info" href="/logout">Выйти</a>
            </sec:authorize>
        </p>
        <div class="navbar-header">
            <a class="navbar-brand" href="/">СОКОЛ</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                <li><a href="/requests">Запросы</a></li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                <li><a href="/users">Пользователи</a></li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                <li><a href="/admin">Настройки</a> </li>
                </sec:authorize>
            </ul>

        </div>

    </div>
</nav>