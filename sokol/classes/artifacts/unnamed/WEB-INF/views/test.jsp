<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <!-- FORM  -->
     <sf:form method="post" action="/requestList/test" enctype="multipart/form-data">
                        <p><input type="file" name="file" ></p>
                        <input type="submit" value="Submit" />
     </sf:form>
    <!-- /FORM -->
</div>


















