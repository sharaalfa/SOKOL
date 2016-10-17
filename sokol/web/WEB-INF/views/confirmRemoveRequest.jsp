<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.10.2016
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css" rel="stylesheet" >
</head>
<body>


<script src="/web/WEB-INF/views/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/i18n/defaults-*.min.js"></script>

<button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#myModal">Показать всплывающее окно</button>
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Заголовок окна</h4>
            </div>
            <div class="modal-body">Текст уведомления</div>
            <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
        </div>
    </div>
</div>





</body>
</html>
