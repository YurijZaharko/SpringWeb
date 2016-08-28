<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 28.08.2016
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form action="/admin/adminCountry" method="post" class="form-inline">
        <div class="form-group">
            <input name="name" placeholder="Name">
            <input type="submit" value="Create" class="btn btn-primary">
        </div>
    </form>
    <table class="table table-hover">
        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${Countries}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td><a href="/admin/adminCountry/delete/${country.id}" class="btn  btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
