<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 25.08.2016
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="container">
    <form>
        <table class="table">
            <tr>

                <td><input name="name" value="Brand name"></td>
                <td><input type="submit" value="Create" name="Create"></td>
            </tr>
        </table>
    </form>
    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${Brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td><a href="/admin/adminBrand/delete/${brand.id}">Delete</a> </td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</div>