    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
        <title>RequestList</title>
        <script type="text/javascript">
            function confirmAction(id) {
                if (confirm("Вы действительно хотите удалить запрос № " + id + " ?")) {
                    return true;
                } else {
                   return false;
                }
            }
        </script>

      <style>
        table {
            width: 100%;
        }
        th {
            font-size: 13px;
            font-weight: normal;
            background: #b9c9fe;
            border-top: 4px solid #aabcfe;
            border-bottom: 1px solid #fff;
            color: #039;
            padding: 8px;
        }
        td {
            background: #e8edff;
            border-bottom: 1px solid #fff;
            color: #669;
            border-top: 1px solid transparent;
            padding: 8px;
        }
        tr:hover td {
            background: #ccddff;
        }

        h2 {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 1.3em;
            margin-top: 1.5em;
            margin-left: 6em;
            color: #FFFFFF;
        }
      </style>
             <div class="panel panel-default" style="background: rgb(32,64,64); height: 60px; margin-bottom: 0px">
               <ul class="nav navbar-nav navbar-left">
                   <li>
                       <h2>ЗАПРОСЫ</h2>
                   </li>
                   <li>
                       <img src="/img/wing.jpg" border="0" style="margin-top: 12px;margin-left: 62em; "> </img>
                   </li>
               </ul>
             </div>

            <div class="panel panel-default" style="height: 70px; margin-bottom: 0px">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a class="btn btn-default"
                           href="/requestList/add?pagenumber=${pagenumber}&sortBy=${sortBy}&sortOrder=${sortOrder}&sortOrderHeader=${sortOrderHeader}"

                           style="width:110px; height:34px; margin-top: 1em; margin-left: 7.5em; padding-top: 5px; background-color: rgb(214,86,43);"
                           role="button">
                            <span style="color: #FFFFFF"> НОВЫЙ</span>
                        </a>
                    </li>
                    <li>
                        <form role="search" class="form-inline">
                            <div class="form-group" style="margin-top:14px; height:34px;">
                                <input type="text" class="form-control" placeholder="Поиск"
                                       style="margin-left: 57em;">
                                <a class="btn btn-default" title="Поиск" href="/requestList/add"
                                   style="width:34px; padding-top: 10px; padding-left: 10px; "
                                   role="button"><span class="glyphicon glyphicon-search"></span>
                                </a>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>

      <table>
         <tr>
             <th style="width: 3%">№</th>
             <th style="width: 8%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=status&sortOrder=${sortOrderHeader}">Статус
                     <c:if test="${sortBy.equals('status')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 14%">
              <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=title&sortOrder=${sortOrderHeader}">Название
                  <c:if test="${sortBy.equals('title')}">
                      <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                  </c:if>
              </a>
             </th>
             <th style="width: 14%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=description&sortOrder=${sortOrderHeader}">Описание
                     <c:if test="${sortBy.equals('description')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 8%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=createdBy&sortOrder=${sortOrderHeader}">Создатель
                     <c:if test="${sortBy.equals('createdBy')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 10%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=assignedTo&sortOrder=${sortOrderHeader}">Исполнитель
                     <c:if test="${sortBy.equals('assignedTo')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 10%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=department&sortOrder=${sortOrderHeader}">Департамент
                     <c:if test="${sortBy.equals('department')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 8%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=requestType&sortOrder=${sortOrderHeader}">Тип
                     <c:if test="${sortBy.equals('requestType')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 8%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=createdDate&sortOrder=${sortOrderHeader}">Создано
                     <c:if test="${sortBy.equals('createdDate')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 8%">
                 <a href="/requestList/list?pagenumber=${pagenumber}&sortBy=updatedDate&sortOrder=${sortOrderHeader}">Обновлено
                     <c:if test="${sortBy.equals('updatedDate')}">
                         <img src=${imgBy} border="0" style="margin-top:0px; margin-left: 3px"> </img>
                     </c:if>
                 </a>
             </th>
             <th style="width: 5%"></th>
         </tr>

        <c:forEach items="${requestAll}" var="lists" step="1">
             <tr class="row2">
                <td>  <c:out value="${lists.requestId}"/></td>
                <td>  <c:out value="${lists.status.requestStatusName}"/></td>
                 <td>
                     <a title="Редактирование запроса"
                        href="/requestList/edit?idRequest=${lists.requestId}&pagenumber=${pagenumber}&sortBy=${sortBy}&sortOrder=${sortOrder}&sortOrderHeader=${sortOrderHeader}">
                        <c:out value="${lists.title}"/>
                     </a>
                 </td>

                 <td>  <c:out value="${lists.description}"/></td>
                 <td>  <c:out value="${lists.createdBy}"/></td>
                 <td>  <c:out value="${lists.assignedTo.fio}"/></td>
                 <td>  <c:out value="${lists.department.title}"/></td>
                 <td>  <c:out value="${lists.requestType.title}"/></td>
                 <td>  <c:out value="${lists.createdDate}"/></td>
                 <td>  <c:out value="${lists.updatedDate}"/></td>
                 <td>  <a class="btn btn-default" title="Удаление запроса"
                          href="/requestList/delete?idRequest=${lists.requestId}"
                          onclick="return confirmAction(${lists.requestId})"
                          role="button">
                           <img src="/img/TrashFull.png" hspace="5" border="0"> </img>
                       </a>
                 </td>
             </tr>
         </c:forEach>
      </table>

     <div class="row">
        <div class="col-md-10">
            <ul class="pagination">
                <li>
                    <a href="" aria-label="Previous"><span aria-hidden="true">&laquo</span></a>
                </li>
                <c:forEach items="${pageTotal}" var="pagenumber" step="1">
                    <li>
                        <a href="/requestList/list?pagenumber=${pagenumber.intValue()}&sortBy=${sortBy}&sortOrder=${sortOrder}">
                            <c:out value="${pagenumber.intValue()}"/>
                        </a>
                    </li>
                </c:forEach>
                <li>
                    <a href="" aria-label="Previous"><span aria-hidden="true">&raquo</span></a>
                </li>
            </ul>
        </div>
     </div>
