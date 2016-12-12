<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <sec:authentication var="user" property="principal" />
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
    <%--  <div class="navbar-header">
&lt;%&ndash;            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
            </button>&ndash;%&gt;
          <img src="img/sokol.jpg" border="0"> <h4>СОКОЛ</h4></img>
            &lt;%&ndash;<a class="navbar-brand topnav" href="/">&ndash;%&gt;


        </div>--%>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAnonymous()">
                <li>
                    <a href="/register">Регистрация</a>
                </li>
                <li>
                    <a href="/login">Войти</a>
                </li>
                </sec:authorize>
                   <sec:authorize access="isAuthenticated()">
                      <li>
                         <a href="/logout">Выход</a>
                       </li>

                      <h4 class="navbar-text">
                          <img src="/img/user.png" hspace="5" border="0"> </img>
                          <b>${user.getUsername()}</b> </h4>
                   </sec:authorize>
            </ul>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <h4>
                            <img src="/img/sokol3.png" hspace="5" border="0"> </img>
                            СОКОЛ</h4>
                    </li>
                    <li>
                        <a href="/">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; Главная</a>
                    </li>
                    <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                        <li><a href="/requestList/list?pagenumber=1">Запросы</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Настройки<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="/department/list">Департаменты</a></li>
                                <li><a href="/users/list">Пользователи</a></li>
                                <li><a href="/requestType/list">Типы запросов</a></li>
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
