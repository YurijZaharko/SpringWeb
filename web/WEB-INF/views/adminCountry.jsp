<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 28.08.2016
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-md-6">
        <form:form action="/admin/adminCountry" method="post" class="form-inline" modelAttribute="country">
            <form:hidden path="id" />
            <custom:hiddenInputs excludeParams="name, id"/>
            <div class="form-group">
                <form:errors path="name"/>
                <form:input path="name" placeholder="name"/>
                <button type="submit" class="btn btn-primary">Create country</button>
            </div>
        </form:form>
        <form:form action="/admin/adminCountry" method="get" modelAttribute="filter" cssClass="form-inline">
            <custom:hiddenInputs excludeParams="search"/>
            <div class="form-group">
                <form:input path="search" placeholder="search" />
                <button type="submit" class="btn btn-primary">Ok</button>
            </div>
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
    <div class="col-md-1">
        <div class="container">
            <custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Page size"/>
        </div>
    </div>

    <table class="table table-hover">
        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${page.content}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td><a href="/admin/adminCountry/delete/${country.id}<custom:allParams/>" class="btn btn-danger">Delete</a></td>
                <td><a href="/admin/adminCountry/update/${country.id}<custom:allParams/>" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
        <%--<tr>--%>
            <%--<td><a href="?page=1&size=1&sort=${param['sort']}&search=${param['search']}">1</a></td>--%>
            <%--<td><a href="?page=1&size=5&sort=${param['sort']}&search=${param['search']}">5</a></td>--%>
            <%--<td><a href="?page=1&size=10&sort=${param['sort']}&search=${param['search']}">10</a></td>--%>
            <%--<td><a href="?page=1&size=20&sort=${param['sort']}&search=${param['search']}">20</a></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><a href="?page=1&size=${page.size}&sort=name&search=${param['search']}">Name asc</a></td>--%>
            <%--<td><a href="?page=1&size=${page.size}&sort=name,desc&search=${param['search']}">Name desc</a></td>--%>
        <%--</tr>--%>
    </table>
    <div class="col-md-12 text-center">
        <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</div>










































