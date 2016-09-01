<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <c:choose>
        <c:when test="${not empty error}">
            <div class="error">${error}</div>
        </c:when>
        <c:otherwise>
            <h2 class="form-signin-heading text-center">Добро пожаловать!</h2>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
<s:url var="authUrl" value="/j_spring_security_check"/>
    <form class="form-signin" action="${authUrl}" method="post">
        <label for="inputEmail" class="sr-only">Эл. почта</label>
        <input name="j_username" type="email" id="inputEmail" class="form-control" placeholder="Эл. почта" required autofocus>
        <label for="inputPassword" class="sr-only">Пароль</label>
        <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Пароль" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить меня
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
        <%--Напомнить пароль--%>
        <a class="btn btn-lg btn-info btn-block" href="/register">Регистрация</a>
    </form>

</div> <!-- /container -->
