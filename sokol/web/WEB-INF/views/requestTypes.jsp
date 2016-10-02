<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>erferferferferf</p>
<c:forEach var="rtype" items="${requestTypes}" step = "1">
    <p>${rtype.title}</p>
</c:forEach>

