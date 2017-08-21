<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 04.09.2016
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>


<div class="container">
    <div class="col-md-3">
        <form:form action="/admin/adminStringProperties" method="post" class="" modelAttribute="stringProperty">
            <form:hidden path="id"/>
            <custom:hiddenInputs excludeParams="propertyName, id"/>
            <div class="form-group">
                <form:errors path="propertyName"/>
                <form:input path="propertyName"/>
                <input type="submit" class="btn btn-primary" value="Create">
            </div>
        </form:form>
    </div>
    <div class="col-md-3">
        <form:form action="/admin/adminStringProperties" method="get" modelAttribute="filter" cssClass="">
            <custom:hiddenInputs excludeParams="search"/>
            <div class="form-group">
                <form:input path="search" placeholder="search" />
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form:form>
    </div>
        <div class="col-md-1">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort ID <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="ID asc" paramValue="id"/>
                    <custom:sort innerHtml="ID desc" paramValue="id,desc"/>
                </ul>
            </div>
        </div>
        <div class="col-md-1">
            <custom:size posibleSizes="1,2,5,10" size="${stringProperties.size}" title="Page size"/>
        </div>


        <table class="table table-hover">
            <tr>
                <td>#</td>
                <td>Property String</td>
            </tr>
            <c:forEach items="${stringProperties.content}" var="stringProperty">
                <tr>
                    <td>${stringProperty.id}</td>
                    <td>${stringProperty.propertyName}</td>
                    <td><a href="/admin/adminProperties/deleteStringProperty/${stringProperty.id}" class="btn btn-danger">Delete</a> </td>
                    <td><a href="/admin/adminProperties/updateStringProperty/${stringProperty.id}" class="btn btn-warning">Update</a> </td>
                </tr>
            </c:forEach>
        </table>
    <div class="col-md-12 text-center">
        <custom:pageable page="${stringProperties}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</div>



