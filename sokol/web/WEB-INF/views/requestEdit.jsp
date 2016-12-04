<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<form action="#" th:action="@{/requestList/edit}" method="post" >
    <style>
    p {
        margin-top: 0.5em; /* Отступ сверху */
        margin-bottom: 1.5em; /* Отступ снизу */
        text-align: right;
        font-weight: 600;
    }
    </style>

    <div class="panel panel-default">
        <div class="panel-body">Редактирование запроса</div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>№ запроса</p>
        </div>

        <div class="col-sm-2">
           <input name="idrequest" class="form-control" value="${request.requestId}"
                  placeholder="${request.requestId}" readonly/>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Название</p>
        </div>

        <div class="col-sm-5">
             <input name="name" class="form-control" value="${request.title}"
                    placeholder="${request.title}"/>
        </div>

        <div class="col-sm-1">
            <p>Создатель</p>
        </div>

        <div class="col-sm-3">
            <input name="creator" class="form-control" value="${request.createdBy}"
                   placeholder="${request.createdBy}" readonly/>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Описание</p>
        </div>

        <div class="col-sm-5">
            <textarea class="form-control" name = "description" rows="3">${request.description}</textarea>
        </div>

        <div class="col-sm-1">
            <p>Дата создания</p>
        </div>

        <div class="col-sm-3">
            <input name="dateCreator" class="form-control" value="${request.createdDate}"
                   placeholder="${request.createdDate}" readonly/>
        </div>
    </div>

    <div class="panel-body"></div>

    <div class="row">
        <div class="col-sm-2">
            <p>Тип запроса</p>
        </div>

        <div class="col-sm-4">
            <select name="idrequesttypes" class="selectpicker">
                <c:forEach items="${requestTypeAll}" var="requesttype" >
                     <c:if test="${requesttype.id == request.requestType.id}">
                        <option value="${requesttype.id}" selected>
                        <c:out value="${requesttype.title}"/>
                        </option>
                    </c:if>
                    <c:if test="${requesttype.id != request.requestType.id}">
                        <option value="${requesttype.id}">
                            <c:out value="${requesttype.title}"/>
                        </option>
                    </c:if>
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
                <c:forEach items="${departmentAll}" var="department" >
                    <c:if test="${department.id == request.department.id}">
                        <option value="${department.id}" selected>
                            <c:out value="${department.title}"/>
                        </option>
                    </c:if>
                    <c:if test="${department.id != request.department.id}">
                        <option value="${department.id}">
                            <c:out value="${department.title}"/>
                        </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="panel-body"></div>
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






