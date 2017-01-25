<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<sec:authentication var="user" property="principal" />






<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
            ${errorMessage}
    </div>
</c:if>

<div class="container">
    <!-- FORM  -->
    <div class="form-wrapper">
        <sf:form method="post" id="requestForm" action="/requestList/add" commandName="department" cssClass="form-horizontal" enctype="multipart/form-data">
            <div class="form-body">
                <input type="hidden" name="creator"         value="${user.getUsername()}" />
                <input type="hidden" name="pagenumber"      value="${pagenumber}">
                <input type="hidden" name="sortBy"          value="${sortBy}">
                <input type="hidden" name="sortOrder"       value="${sortOrder}">
                <input type="hidden" name="sortOrderHeader" value="${sortOrderHeader}">

                <div class="form-group">
                    <label for="inputTitle"  class="control-label col-sm-3">Название</label>
                    <div class="col-sm-8">
                        <input name="title" id="inputTitle" class="form-control" placeholder="Название подразделения" required autofocus/>
                    </div>
                </div>


                <div class="form-group">
                    <label for="inputType"  class="control-label col-sm-3">Тип запроса</label>
                    <div class="col-sm-8">
                        <select name="idrequesttype"  id="inputType" class="form-control">
                            <c:forEach items="${requestTypeAll}" var="requesttype" >
                                <option value="${requesttype.id}">
                                    <c:out value="${requesttype.title}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputDepartment"  class="control-label col-sm-3">Департамент</label>
                    <div class="col-sm-8">
                        <select name="iddepartment" id="inputDepartment" class="form-control">
                            <c:forEach items="${departmentAll}" var="department" >
                                <option value="${department.id}">
                                    <c:out value="${department.title}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <label for="inputDescrition"  class="control-label col-sm-3">Описание</label>
                    <div class="col-sm-8">
                        <textarea  name="description" id="inputDescrition" placeholder="Описание типа запроса" class="form-control" rows="3" ></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputScreenShot"  class="control-label col-sm-3">Приложение</label>
                    <div class="col-sm-8">
                        <%--<p><input type="file" name="fileScreenShot" id="inputScreenShot">--%>
                        <p><input type="file" name="file" id="inputScreenShot">
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-sm-3"></div>
                    <div class="col-sm-8">

                        <a href="#" onclick="document.forms['requestForm'].submit();" class="btn-save pull-left">СОХРАНИТЬ</a>
                        <a href="/department/list" class="btn-close pull-right">ЗАКРЫТЬ</a>
                    </div>
                </div>


            </div>
        </sf:form>
        <%--<div class="audit-info">--%>
            <%--<table>--%>
                <%--<tr>--%>
                    <%--<th>АВТОР</th>--%>
                    <%--<td>Кузнецов Денис</td>--%>
                    <%--<th>ДАТА СОЗДАНИЯ</th>--%>
                    <%--<td>01.01.2019 12:78:21</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<th>ИЗМЕНЕНО</th>--%>
                    <%--<td>Кузнецов Денис</td>--%>
                    <%--<th>ДАТА ИЗМЕНЕНИЯ</th>--%>
                    <%--<td>01.01.2019 12:78:02</td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</div>--%>
    </div>
    <!-- /FORM -->
</div>
















