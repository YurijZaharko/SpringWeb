<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 21.08.2016
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
    <form:form action="/admin/adminProduct" method="post" modelAttribute="productForm" class="form-inline">
        <%--<form:errors path="*"/>--%>
        <form:hidden path="id"/>
        <div class="form-group">
            <form:errors path="productName"/>
            <form:input path="productName" placeholder="Name"/>

            <form:errors path="partNumber"/>
            <form:input path="partNumber" placeholder="Part number"/>

            <form:errors path="price"/>
            <form:input path="price" placeholder="Price"/>

            <form:select path="brand" class="form-control">
                <c:forEach items="${brands}" var="brand">
                    <c:choose>
                        <c:when test="${brand.id eq productForm.brand.id}">
                            <option value="${brand.id}" selected="selected">${brand.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${brand.id}">${brand.name}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
            <form:select path="country" class="form-control">
                <c:forEach items="${countries}" var="country">
                    <c:choose>
                        <c:when test="${country.id eq productForm.country.id}">
                            <option value="${country.id}" selected="selected">${country.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${country.id}">${country.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <form:select path="category" class="form-control">
                <c:forEach items="${categories}" var="category">
                    <c:choose>
                        <c:when test="${category.id eq productForm.category.id}">
                            <option value="${category.id}" selected ="selected">${category.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${category.id}">${category.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <input type="submit" class="btn btn-primary" value="Create product">
        </div>
    </form:form>
    <table class="table table-hover">
        <tr>
            <td>#</td>
            <td>Name</td>
            <td>Part number</td>
            <td>Price</td>
            <td>Brand</td>
            <td>Country</td>
            <td>Category</td>
        </tr>
        <c:forEach items="${Products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.productName}</td>
                <td>${product.partNumber}</td>
                <td>${product.price}</td>
                <td>${product.brand.name}</td>
                <td>${product.country.name}</td>
                <td>${product.category.name}</td>
                <td><a href="/admin/adminProduct/delete/${product.id}" class="btn btn-danger">Delete</a> </td>
                <td><a href="/admin/adminProduct/update/${product.id}" class="btn btn-warning">Update</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

