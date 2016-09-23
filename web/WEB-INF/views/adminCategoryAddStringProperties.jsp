<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 11.09.2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form action="/admin/adminCategory/categoryAddStringProperties" method="get" modelAttribute="categoryAddStringProperties">
    <div class="form-group">
        <form:checkboxes path="stringPropertiesList" items="${brands}" itemLabel="name" itemValue="id"/>
    </div>

</form:form>