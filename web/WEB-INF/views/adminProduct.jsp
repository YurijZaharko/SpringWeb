<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 21.08.2016
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
    <form action="/admin/adminProduct" method="post" class="form-inline">
        <div class="form-group">
            <input name="name" placeholder="Name">
            <input name="partNumber" placeholder="Part number">
            <input name="price" placeholder="Price">
            <select name="brandId">
                <c:forEach items="${brands}" var="brand">
                    <option value="${brand.id}">
                        ${brand.name}
                    </option>
                </c:forEach>
            </select>
            <select name="countryId">
                <c:forEach items="${countries}" var="country">
                    <option value="${country.id}">
                        ${country.name}
                    </option>
                </c:forEach>
            </select>
            <select name="categoryId">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">
                        ${category.name}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" class="btn btn-primary" value="Create product">
        </div>
    </form>
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
            </tr>
        </c:forEach>
    </table>
</div>

