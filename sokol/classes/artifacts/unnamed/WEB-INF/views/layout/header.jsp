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
                    <a href="/register">Регистрация</a>
                </li>
                <li>
                <sec:authorize access="isAnonymous()">
                    <a href="/login">Войти</a>
                </sec:authorize>
                </li>

                   <sec:authorize access="isAuthenticated()">
                      <li>
                         <a href="/logout">Выход</a>
                       </li>
                      <h4 class="navbar-text"><b>${user.getUsername()}</b> </h4>
                   </sec:authorize>
                </li>
            </ul>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                        <li><a href="/requestList">Запросы</a></li>
                    </sec:authorize>

<%--                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li><a href="/users">Пользователи</a></li>
                    </sec:authorize>--%>

                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Настройки<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="#">Департаменты</a></li>
                                <li><a href="#">Пользователи</a></li>
                                <li><a href="#">Типы запросов</a></li>
                            </ul>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
  </nav>
</html>
