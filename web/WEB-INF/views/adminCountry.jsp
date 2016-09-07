<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="form-group">
            <%--<input name="name" placeholder="Name">--%>
            <form:errors path="name"/>
            <form:input path="name"/>
                <input type="submit" value="Create" class="btn btn-primary">
        </div>
    </form:form>
    <table class="table table-hover">
        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${countries}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td><a href="/admin/adminCountry/delete/${country.id}" class="btn btn-danger">Delete</a></td>
                <td><a href="/admin/adminCountry/update/${country.id}" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
