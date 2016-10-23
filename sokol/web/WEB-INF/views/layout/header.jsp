<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ru">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="user" property="principal" />

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand topnav" href="/"><h4>СОКОЛ</h4></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#contact">О нас</a>
                </li>
                <li>
                    <a href="/register">Регистрация</a>
                </li>
                <li>
                <sec:authorize access="isAnonymous()">
                    <a href="/login">Войти</a>
                </sec:authorize>
                </li>
                <li>
                    <sec:authorize access="isAuthenticated()">
<%--                        Вы вошли как <b style="padding-right: 10px;"> ${user.getUsername()}</b>
                        <a class="btn-sm btn-info" href="/logout">Выйти</a>--%>
                        <table>
                            <tr>
                                <th>
                                    Вы вошли как <b> ${user.getUsername()}</b>
                                </th>

                                <th>
                                    <a class="btn-sm btn-info" href="/logout">Выйти</a>

                                </th>

                            </tr>

                        </table>
                     <%--   <a class="btn btn-default" title="Выйти"
                           role="button"><span class="glyphicon glyphicon-eye-open"></span></a>--%>
                    </sec:authorize>



                </li>

            </ul>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                        <li><a href="/listRequest">Запросы</a></li>
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
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
</html>