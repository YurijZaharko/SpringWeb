<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 25.08.2016
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="col-md-4">
        <form:form action="/admin/adminBrand" method="post"  modelAttribute="brand">
            <form:hidden path="id"/>
            <div class="form-group">
                <%--<input name="name" placeholder="Name">--%>
                <form:errors path="name"/>
                    <form:input path="name"/>
                    <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form:form>
        <form:form action="/admin/adminBrand" method="get" modelAttribute="brandFilterForm" cssClass="form-group">
            <form:input path="search"/><button type="submit" class="btn btn-primary">Search</button>
        </form:form>
    </div>
    <div class="col-md-1">
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort ID <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <custom:sort innerHtml="ID asc" paramValue="id"/>
                <custom:sort innerHtml="ID desc" paramValue="id,desc"/>
            </ul>
        </div>
    </div>
    <div class="col-md-1">
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort name <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <custom:sort innerHtml="Name asc" paramValue="name"/>
                <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
            </ul>
        </div>
    </div>
    <div class="col-md-2">
        <div class="container">
            <custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Page size"/>
        </div>
    </div>
    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${page.content}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td><a href="/admin/adminBrand/delete/${brand.id}<custom:allParams/>" class="btn btn-danger">Delete</a> </td>
                <td><a href="/admin/adminBrand/update/${brand.id}<custom:allParams/>" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="col-md-12 text-center">
        <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</div>