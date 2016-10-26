<%--
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Название компании и кнопка, которая отображается для мобильных устройств группируются для лучшего отображения при свертывании -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Группируем ссылки, формы, выпадающее меню и прочие элементы -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
--%>




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



<%--                        Вы вошли как <b style="padding-right: 10px;"> ${user.getUsername()}</b>
                        <a class="btn-sm btn-info" href="/logout">Выйти</a>--%>
                       <%-- <table>--%>
                        <li>
                            <a href="/logout">Выход</a>
                        </li>


<%--                    <style>
                        div {
                            margin-bottom: 5px; /* Отступ сверху */
                        }
                    </style>--%>


                                    <%--<h4 class="navbar-brand" href="#">Вы вошли как</h4>--%>




                       <%-- </table>--%>
                     <%--   <a class="btn btn-default" title="Выйти"
                           role="button"><span class="glyphicon glyphicon-eye-open"></span></a>--%>
                    <h4 class="navbar-text"><b>${user.getUsername()}</b> </h4>
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
