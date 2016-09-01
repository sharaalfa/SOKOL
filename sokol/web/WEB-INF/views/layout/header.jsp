<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <p class="navbar-text navbar-right">
            <a class="btn-sm btn-info" href="/login">Войти</a>
        </p>
        <div class="navbar-header">
            <a class="navbar-brand" href="/">СОКОЛ</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/requests">Запросы</a></li>
                <li><a href="/users">Пользователи</a></li>
                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
                <li><a href="/admin">Настройки</a> </li>
                </sec:authorize>
            </ul>

        </div>

    </div>
</nav>