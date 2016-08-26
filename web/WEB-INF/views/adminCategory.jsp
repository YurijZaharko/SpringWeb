<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 15.08.2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <form action="/admin/adminCategory" method="post" class="form-inline">
        <div class="form-group">
            <input name="name" placeholder="Name">
            <input type="submit" class="btn btn-primary" placeholder="Create">
        </div>
    </form>

    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${Categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><a href="/admin/adminCategory/delete/${category.id}" class="btn btn-danger">Delete</a> </td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</div>
