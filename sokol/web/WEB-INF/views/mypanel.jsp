<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>My panel</h2>
<script type="text/javascript">
    function onCreateRequest() {
        $('#myModal .modal-title').text("Создать запрос");
        $('#requestId').val('');
        $('#title').val('');
        $('#description').val('');

        $('#myModal').modal("show");
    }

    function onEditRequest(requestId) {
        $('#myModal .modal-title').text("Изменить запрос");
        $('#requestId').val($('#request-' + requestId).find('.request-id').val());
        $('#title').val($('#request-' + requestId).find('.request-title').text());
        $('#description').val($('#request-' + requestId).find('.request-description').text());
        $('#myModal').modal("show");
    }
</script>

<a href="#" class="btn btn-primary" id="create_request" onclick="onCreateRequest()">Создать запрос</a>

<div class="row">

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <input type="hidden" name="requestId" id="requestId">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Заголовок:</label>
                        <input type="text" id="title" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="description">Описание:</label>
                        <textarea class="form-control" rows="5" id="description"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">Сохранить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>

        </div>
    </div>

<div class="panel panel-default col-md-6">
    <div class="panel-heading">Мои запросы</div>
    <div class="panel-body">
    <c:forEach var="request" items="${myRequests}" step="1">
        <div class="panel" id="request-${request.requestId}">
            <div class="request-id">${request.requestId}</div>
            <div><a href="#" class="request-title" onclick="onEditRequest(${request.requestId})">${request.title}</a></div>
            <div class="request-description">${request.description}</div>
        </div>
    </c:forEach>
    </div>
</div>

 <div class="panel panel-default col-md-6">
    <div class="panel-heading">Мне в обработку</div>
    <div class="panel-body">
        <c:forEach var="request" items="${forMeRequests}" step="1">
            <div class="panel"  id="request-${request.requestId}">
                <div  class="request-id">${request.requestId}</div>
                <div><a href="#" class="request-title" onclick="onEditRequest(${request.requestId})">${request.title}</a></div>
                <div class="request-description">${request.description}</div>
            </div>
        </c:forEach>
    </div>
</div>

</div>