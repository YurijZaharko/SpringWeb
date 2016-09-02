<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 25.08.2016
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <form:form action="/admin/adminBrand" method="post" class="form-inline" modelAttribute="brand">
        <form:hidden path="id"/>
        <div class="form-group">
            <%--<input name="name" placeholder="Name">--%>
            <form:errors path="name"/>
                <form:input path="name"/>
            <input type="submit" class="btn btn-primary" value="Create">
        </div>
    </form:form>

    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${Brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td><a href="/admin/adminBrand/delete/${brand.id}" class="btn btn-danger">Delete</a> </td>
                <td><a href="/admin/adminBrand/update/${brand.id}" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>