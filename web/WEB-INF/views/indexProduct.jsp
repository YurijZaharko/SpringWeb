<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 23.04.2017
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="col-md-2">
        <form:form action="/category" method="get" modelAttribute="productFrontFilterForm">
            <form:hidden path="categoryId"/>
            <div class="text-center ">
                <h3>${productFrontFilterForm.categoryName}</h3>
            </div>
            <div class="form-group">
                <form:input path="minString" placeholder="min" class="form-control"/>
                <form:input path="maxString" placeholder="max" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="brandId">Brand</label>
                <form:checkboxes path="brandId" items="${brands}" itemLabel="name" itemValue="id" id="brandId"/>
            </div>
            <div class="form-group">
                <label for="countryIdList">Country</label>
                <form:checkboxes path="countryIdList" items="${countries}" itemLabel="name" itemValue="id" id="countryIdList"/>
            </div>
            <c:forEach items="${propertyMap}" var="entry">
                <div class="form-group">
                         <form:label path="${entry.key}" itemLabel="propertyName" itemValue="id"/>
                            <form:checkboxes items="${entry.value}" path="${entry.value}" />
                </div>
            </c:forEach>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Ok</button>
            </div>
        </form:form>
    </div>
    <div class="col-md-7">
        <c:forEach items="${products.content}" var="product">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img width="200" src="/images/product/${product.id}${product.path}?version=${product.version}">
                    <div class="caption">
                        <h2>${product.id}</h2>
                        <h3>${product.productName}</h3>
                        <h4>${product.sellPrice}</h4>
                        <p><a href="#" class="btn btn-primary" role="button">Specification</a> <a href="#" class="btn btn-default" role="button">Add to cart</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--<div class="col-md-6">--%>
        <%--<custom:size posibleSizes="8,16,32,64" size="${products.size}" title="Розмір сторінки"/>--%>
    <%--</div>--%>
    <%--<div class="col-md-12 text-center">--%>
        <%--<custom:pageable page="${products}" cell="<li></li>" container="<ul class='pagination'></ul>" />--%>
    <%--</div>--%>
</div>
