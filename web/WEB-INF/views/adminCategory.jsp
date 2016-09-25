<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 15.08.2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <form:form action="/admin/adminCategory" method="post" class="form-inline" modelAttribute="category">
        <form:hidden path="id"/>
        <div class="form-group">
            <%--<input name="name" placeholder="Name">--%>
            <form:errors path="name"/>
            <form:input path="name"/>
            <input type="submit" class="btn btn-primary" placeholder="Create">
        </div>
    </form:form>

    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><a href="/admin/adminCategory/categoryWithProperty/${category.id}" class="btn btn-primary">Add String Property</a></td>
                <td><a href="" class="btn btn-primary">Add Integer Property</a></td>
                <td><a href="/admin/adminCategory/delete/${category.id}" class="btn btn-danger">Delete</a> </td>
                <td><a href="/admin/adminCategory/update/${category.id}" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
