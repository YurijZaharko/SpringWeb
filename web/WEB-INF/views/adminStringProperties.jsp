<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 04.09.2016
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-lg-6">
        <form:form action="/admin/adminStringProperties" method="post" class="form-inline" modelAttribute="stringProperty">
            <form:hidden path="id"/>
            <div class="form-group">
                <form:errors path="propertyName"/>
                <form:input path="propertyName"/>
                <input type="submit" class="btn btn-primary" value="Create">
            </div>
        </form:form>
        <table class="table table-hover">
            <tr>
                <td>#</td>
                <td>Property String</td>
            </tr>
            <c:forEach items="${stringProperties}" var="stringProperty">
                <tr>
                    <td>${stringProperty.id}</td>
                    <td>${stringProperty.propertyName}</td>
                    <td><a href="/admin/adminProperties/deleteStringProperty/${stringProperty.id}" class="btn btn-danger">Delete</a> </td>
                    <td><a href="/admin/adminProperties/updateStringProperty/${stringProperty.id}" class="btn btn-warning">Update</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

