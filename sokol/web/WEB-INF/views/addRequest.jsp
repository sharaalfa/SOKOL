<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<s:url var="authUrl" value="/j_spring_security_check"/>
    <form class="form-signin" action="${authUrl}" method="post">

    <div class="col-sm-4">
        <h4 class="form-signin-heading">Название</h4>
        <label for="title" class="sr-only">title</label>
        <input name="username" id="title" class="form-control"/>

        <h4 class="form-signin-heading">Описание</h4>
        <label for="description" class="sr-only">description</label>
        <input name="username" id="description" class="form-control"/>

        <h4 class="form-signin-heading">assignedTo</h4>
        <label for="assignedTo" class="sr-only">description</label>
        <input name="assignedTo" id="assignedTo" class="form-control"/>

        <button type="button" class="btn btn-success">ОК</button>
        <button type="button" class="btn btn-danger">Отмена</button>
    </div>

    <div class="col-sm-2">
        <h4 class="form-signin-heading">Дата создания</h4>
        <label for="createdDate" class="sr-only">title</label>
        <input name="username" id="createdDate" class="form-control"/>

        <h4 class="form-signin-heading">Дата обновления</h4>
        <label for="updatedDate" class="sr-only">title</label>
        <input name="username" id="updatedDate" class="form-control"/>
    </div>

    <div class="col-sm-4">
        <h4 class="form-signin-heading">Кем создано</h4>
        <label for="createdBy" class="sr-only">title</label>
        <input name="username" id="createdBy" class="form-control"/>

        <h4 class="form-signin-heading">Кем обновлено</h4>
        <label for="updatedBy" class="sr-only">title</label>
        <input name="username" id="updatedBy" class="form-control"/>

    </div>
    </div>
    </form>

</div> <!-- /container -->
