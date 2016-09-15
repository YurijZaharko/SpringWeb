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
    <form:form action="/admin/adminCountry" method="post" class="form-inline" modelAttribute="country">
        <form:hidden path="id"/>
        <c:forEach items="${param}" var="parameter">
            <c:forEach items="${parameter.value}" var="value">
                <c:if test="${parameter.key ne 'name' and parameter.key ne 'id'}">
                    <input type="hidden" name="${parameter.key}" value="${value}">
                </c:if>
            </c:forEach>
        </c:forEach>
        <div class="form-group">
            <form:errors path="name"/>
            <form:input path="name"/>
            <input type="submit" value="Create" class="btn btn-primary">
        </div>
    </form:form>
    <form:form action="/admin/adminCountry" method="get" modelAttribute="filter">
        <c:forEach items="${param}" var="parameter">
            <c:forEach items="${parameter.value}" var="value">
                <c:if test="${parameter.key ne 'search'}">
                    <input type="hidden" name="${parameter.key}" value="${value}">
                </c:if>
            </c:forEach>
        </c:forEach>
        <table class="table table-hover">
            <tr>
                <td><form:errors path="search"/>
                    <form:input path="search" placeholder="Search"/>
                    <button type="submit" class="btn btn-primary">OK</button></td>
            </tr>
        </table>
    </form:form>
    <table class="table table-hover">
        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${page.content}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td><a href="/admin/adminCountry/delete/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}" class="btn btn-danger">Delete</a></td>
                <td><a href="/admin/adminCountry/update/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="?page=1&size=1&sort=${param['sort']}&search=${param['search']}">1</a></td>
            <td><a href="?page=1&size=5&sort=${param['sort']}&search=${param['search']}">5</a></td>
            <td><a href="?page=1&size=10&sort=${param['sort']}&search=${param['search']}">10</a></td>
            <td><a href="?page=1&size=20&sort=${param['sort']}&search=${param['search']}">20</a></td>
        </tr>
        <tr>
            <td><a href="?page=1&size=${page.size}&sort=name&search=${param['search']}">Name asc</a></td>
            <td><a href="?page=1&size=${page.size}&sort=name,desc&search=${param['search']}">Name desc</a></td>
        </tr>
    </table>
    <div class="col-md-12 text-center">
        <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
    </div>
</div>










































