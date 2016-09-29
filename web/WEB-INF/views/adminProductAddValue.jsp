<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 29.09.2016
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/admin/adminProduct/addValue" method="get" modelAttribute="productAndValue">
    <c:forEach items="${productAndValue.content}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.partNumber}</td>
            <c:forEach items="${product.category.integerPropertiesList}" var="propertyInt">
                <tr>
                    <td>${propertyInt.listOfPropertyAndValueInteger.valueOfIntegerPropertiesList.value}</td>
                </tr>
            </c:forEach>
            <c:forEach items="${product.category.stringPropertiesList}" var="propertyStr">
                <tr>
                    <td>${propertyStr.listOfPropertyAndValueStrings.valueOfStringPropertiesList.stringValue}</td>
                </tr>
            </c:forEach>
        </tr>
    </c:forEach>
</form:form>