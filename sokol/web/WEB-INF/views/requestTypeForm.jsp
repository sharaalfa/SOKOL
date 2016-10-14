<%--
  Created by IntelliJ IDEA.
  User: bmik98
  Date: 09.10.2016
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>

<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>EditRequestType</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css"
          rel="stylesheet">
</head>
<body>

<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/i18n/defaults-ru_RU.min.js"></script>

<form action="editRequestType" method="post">

    <div class="panel panel-default">
        <div class="panel-heading">СОКОЛ</div>
        <div class="panel-body">Редактирование запроса</div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Название</p>
        </div>

        <div class="col-sm-5">
            <input name="name" class="form-control" id="id" placeholder="${requestType.title}"/>
        </div>

    </div>


    <div class="row">
        <div class="col-sm-2">
            <p>Описание</p>
        </div>

        <div class="col-sm-5">
            <input class="form-control" name="description" id="description" rows="3"
                   placeholder="${requestType.description}"/>
        </div>

        <div class="col-sm-1">
            <p>Дата создания</p>
        </div>

        <div class="col-sm-3">
            <input name="dateCreator" class="form-control" id="idDateCreator" placeholder="${requestType.createdDate}"
                   readonly/>
        </div>

        <div class="col-sm-4">
            <input name="id" class="form-control" id="requestTypeId" placeholder="${requestType.id}"
                   readonly/>
        </div>
    </div>

    <div class="panel-body"></div>

    <div class="panel-body"></div>
    <div class="panel-body"></div>
    <div class="panel-body"></div>
    <div class="panel-body"></div>

    <div class="row">
        <div class="col-sm-1">
            <button type="submit" class="btn-success" href="/requestTypes">Подтвердить</button>
        </div>

        <div class="col-sm-1">
            <button type="button" class="btn-danger" href="/requestTypes">Отменить</button>
        </div>
        <div class="col-sm-5"></div>
    </div>
</form>


</body>
</html>
