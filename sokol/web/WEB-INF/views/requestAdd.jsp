<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="user" property="principal" />

<form action="requestAdd" method="post" >
    <style>
        p {
            margin-top: 0.5em; /* Отступ сверху */
            margin-bottom: 1.5em; /* Отступ снизу */
            text-align: right;
            font-weight: 600;
        }
    </style>

    <div class="panel panel-default">
       <div class="panel-body">Создание запроса</div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Название</p>
        </div>

        <div class="col-sm-5">
          <input name="name" class="form-control" placeholder="Название запроса"/>
        </div>

        <div class="col-sm-1">
            <p>Создатель</p>
        </div>

        <div class="col-sm-3">
            <sec:authorize access="isAnonymous()">
                <input name="creator" class="form-control" value="" readonly/>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <input name="creator" class="form-control" value="${user.getUsername()}" readonly/>
            </sec:authorize>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Описание</p>
        </div>

        <div class="col-sm-5">
            <textarea class="form-control" name = "description" rows="3" placeholder="Описание запроса"></textarea>
        </div>
    </div>

    <div class="panel-body"></div>

    <div class="row">
        <div class="col-sm-2">
            <p>Тип запроса</p>
        </div>
        <div class="col-sm-4">
            <select name="idrequest" class="selectpicker">
                <c:forEach items="${requestTypeAll}" var="requestType2">
                    <option value="${requestType2.id}"> <c:out value="${requestType2.title}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Департамент</p>
        </div>
        <div class="col-sm-4">
            <select name="iddepartment" class="selectpicker">
                <c:forEach items="${departmentAll}" var="department">
                    <option value="${department.id}"><c:out value="${department.title}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="panel-body"></div>
    <div class="panel-body"></div>
    <div class="panel-body"></div>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-1">
            <button type="submit" class="btn btn-success">Подтвердить</button>
        </div>

        <div class="col-sm-1">
            <a class="btn btn-danger" href="/requestList">Отменить</a>
        </div>

        <div class="col-sm-5"></div>
    </div>
</form>













