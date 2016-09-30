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
        <div class="form-group">
            <input type="submit" class="btn btn-primary" placeholder="Add">
        </div>
        <form:hidden path="id"/>
        <form:hidden path="parentId"/>
        <form:hidden path="categoryChild"/>
        <form:hidden path="productList"/>
        <form:hidden path="integerPropertiesList"/>
        <div class="form-group">
            <%--<form:select path="name" items="${categoriesWithProperty}" class="form-control" itemLabel="name" itemValue="id"/>--%>
        </div>

        <div class="form-group">
            <form:select path="stringPropertiesList" items="${stringProperties}" itemLabel="propertyName" itemValue="id"/>
        </div>
        <%--<div class="form-group">--%>
            <%--<form:select path="integerPropertiesList" items="${integerProperties}" itemLabel="name" itemValue="id"/>--%>
        <%--</div>--%>
    </form:form>


</div>