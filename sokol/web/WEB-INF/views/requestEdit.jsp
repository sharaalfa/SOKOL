<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>





<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
            ${errorMessage}
    </div>
</c:if>
<div class="container">
    <!-- FORM  -->
    <div class="form-wrapper">
        <sf:form method="post" action="/requestList/edit" id="requestForm" cssClass="form-horizontal">
            <div class="form-body">
                <input type="hidden" name="idrequest" value="${request.requestId}">
                <input type="hidden" name="pagenumber" value="${pagenumber}">
                <input type="hidden" name="sortBy" value="${sortBy}">
                <input type="hidden" name="sortOrder" value="${sortOrder}">
                <input type="hidden" name="sortOrderHeader" value="${sortOrderHeader}">
                <div class="form-group">
                    <label class="control-label col-sm-3">Номер запроса</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${request.requestId}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputTitle"  class="control-label col-sm-3">Название</label>
                    <div class="col-sm-8">
                        <input name="title" id="inputTitle" class="form-control" placeholder="Название подразделения" value="${request.title}" required autofocus/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputType"  class="control-label col-sm-3">Тип запроса</label>
                    <div class="col-sm-8">
                        <select name="idrequesttypes"  id="inputType" class="form-control">
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

                <div class="form-group">
                    <label for="inputDepartment"  class="control-label col-sm-3">Департамент:</label>
                    <div class="col-sm-8">
                        <select name="iddepartment" id="inputDepartment" class="form-control">
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


                <div class="form-group">
                    <label for="inputDescrition"  class="control-label col-sm-3">Описание</label>
                    <div class="col-sm-8">
                        <textarea  name="description" id="inputDescrition" placeholder="Описание типа запроса" class="form-control" rows="3" >${request.description}</textarea>
                    </div>
                </div>


                <div class="form-group">
                    <div class="control-label col-sm-3"></div>
                    <div class="col-sm-8">
                        <a href="#" onclick="document.forms['requestForm'].submit();" class="btn-save pull-left">СОХРАНИТЬ</a>
                        <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=${sortBy}&sortOrder=${sortOrder}&sortOrderHeader=${sortOrderHeader}" class="btn-close pull-right">ЗАКРЫТЬ</a>
                    </div>
                </div>


            </div>
        </sf:form>
        <div class="audit-info">
            <table>
                <tr>
                    <th>АВТОР</th>
                    <td>${request.createdBy}</td>
                    <th>ДАТА СОЗДАНИЯ</th>
                    <td>${request.createdDate}</td>
                </tr>
                <tr>
                    <th>ИЗМЕНЕНО</th>
                    <td>${request.updatedBy}</td>
                    <th>ДАТА ИЗМЕНЕНИЯ</th>
                    <td>${request.updatedDate}</td>
                </tr>
            </table>
        </div>
    </div>
    <!-- /FORM -->
</div>

