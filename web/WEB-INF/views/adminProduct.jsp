<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 21.08.2016
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function() {
        $('select[name=system]').chosen();
        $('select[name=ingredient]').chosen();
    });
</script>

<div class="container-fluid">
    <div class="col-md-3">
        <form:form action="/admin/adminProduct" cssClass="form-horizontal" method="get" modelAttribute="productFilterForm">
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Ok</button>
            </div>
            <div class="form-group">
                <form:input path="minString" placeholder="min" class="form-control"/>
                <form:input path="maxString" placeholder="max" class="form-control"/>
            </div>
            <div class="form-group">
                <h4>Brand</h4>
            </div>
            <div class="form-group">
                <form:checkboxes path="brandId" items="${brands}" itemLabel="name" itemValue="id"/>
            </div>
            <div class="form-group">
                <h4>Country</h4>
            </div>
            <div class="form-group">
                <form:checkboxes path="countryId" items="${countries}" itemLabel="name" itemValue="id"/>
            </div>
            <div class="form-group">
                <h4>Category</h4>
            </div>
            <div class="form-group">
                <form:checkboxes path="categoryId" items="${categories}" itemLabel="name" itemValue="id"/>
            </div>

        </form:form>
    </div>
    <div class="col-md-9">
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

                <form:select path="brand" items="${brands}" class="form-control" itemLabel="name" itemValue="id">
                    <%--<c:forEach items="${brands}" var="brand">--%>
                    <%--<c:choose>--%>
                    <%--<c:when test="${brand.id eq productForm.brand.id}">--%>
                    <%--<option value="${brand.id}" selected="selected">${brand.name}</option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                    <%--<option value="${brand.id}">${brand.name}</option>--%>
                    <%--</c:otherwise>--%>
                    <%--</c:choose>--%>

                    <%--</c:forEach>--%>
                </form:select>
                <form:select path="country" items="${countries}" class="form-control" itemLabel="name" itemValue="id">
                    <%--<c:forEach items="${countries}" var="country">--%>
                    <%--<c:choose>--%>
                    <%--<c:when test="${country.id eq productForm.country.id}">--%>
                    <%--<option value="${country.id}" selected="selected">${country.name}</option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                    <%--<option value="${country.id}">${country.name}</option>--%>
                    <%--</c:otherwise>--%>
                    <%--</c:choose>--%>
                    <%--</c:forEach>--%>
                </form:select>
                <form:select path="category" items="${categories}" class="form-control" itemLabel="name" itemValue="id">
                    <%--<c:forEach items="${categories}" var="category">--%>
                    <%--<c:choose>--%>
                    <%--<c:when test="${category.id eq productForm.category.id}">--%>
                    <%--<option value="${category.id}" selected ="selected">${category.name}</option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                    <%--<option value="${category.id}">${category.name}</option>--%>
                    <%--</c:otherwise>--%>
                    <%--</c:choose>--%>
                    <%--</c:forEach>--%>
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
            <c:forEach items="${Products.content}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.partNumber}</td>
                    <td>${product.price}</td>
                    <td>${product.brand.name}</td>
                    <td>${product.country.name}</td>
                    <td>${product.category.name}</td>
                    <td><a href="/admin/adminProduct/delete/${product.id}<custom:allParams/>" class="btn btn-danger">Delete</a> </td>
                    <td><a href="/admin/adminProduct/update/${product.id}<custom:allParams/>" class="btn btn-warning">Update</a> </td>
                </tr>
            </c:forEach>
        </table>
        <div class="col-md-6">
            <custom:size posibleSizes="1,2,5,10" size="${Products.size}" title="Розмір сторінки"/>
        </div>
    </div>
</div>

