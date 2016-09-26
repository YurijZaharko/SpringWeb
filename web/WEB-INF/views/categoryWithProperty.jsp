<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 11.09.2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form:form action="/admin/adminCategory/categoryWithProperty" method="post" modelAttribute="category">
        <form:hidden path="id"/>
        <div class="form-group">
            <form:select path="name" items="${categoriesWithProperty}" class="form-control" itemLabel="name" itemValue="id"/>
        </div>
        <div class="container">
            <input type="submit" class="btn btn-primary" placeholder="Add">
        </div>
        <div class="form-group">
            <form:checkboxes path="stringPropertiesList" items="${stringPropertiesList}" itemLabel="propertyName" itemValue="id"/>
        </div>
    </form:form>
    <%--<form:form action="/admin/adminCategory/categoryWithProperty" method="post" modelAttribute="category">--%>
        <%--<div class="container">--%>
            <%--<input type="submit" class="btn btn-primary" placeholder="Add">--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<form:checkboxes path="" items="${}" itemLabel="name" itemValue="id"/>--%>
        <%--</div>--%>
    <%--</form:form>--%>

</div>