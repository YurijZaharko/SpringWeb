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
<%--<form:form action="/admin/adminProduct/addValue" method="post" modelAttribute="oneProduct">--%>
    <%--<table class="table table-hover">--%>
        <%--<tr class="active">--%>
            <%--<td>Product id</td>--%>
            <%--<td>Product name</td>--%>
            <%--<td>Part number</td>--%>

        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>${oneProduct.id}</td>--%>
            <%--<td>${oneProduct.productName}</td>--%>
            <%--<td>${oneProduct.partNumber}</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<br>--%>
    <%--<table class="table table-hover">--%>
        <%--<tr class="active">--%>
            <%--<td>Property name</td>--%>
            <%--<td>Property value</td>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${properties}" var="property">--%>
            <%--<tr>--%>
                <%--<td>${property.propertyName}</td>--%>
                <%--<td>--%>
                    <%--<c:forEach items="${property.propertyAndValueStrings}" var="propertyAndValueStrings">--%>
                        <%--<c:forEach items="${propertyAndValueStrings.valueOfStringPropertiesList}" var="valueOfStringPropertiesList">--%>
                            <%--${valueOfStringPropertiesList.stringValue}--%>
                        <%--</c:forEach>--%>
                    <%--</c:forEach>--%>
                <%--</td>--%>
                <%--<td></td>--%>

            <%--</tr>--%>

        <%--</c:forEach>--%>

    <%--</table>--%>

<%--</form:form>--%>

<form:form action="/admin/adminProduct/addValue/show" method="post" modelAttribute="propertyAndValueStringsForm">
    <table class="table table-hover">
        <tr class="active">
            <td>Product id</td>
            <td>Product name</td>
            <td>Part number</td>
        </tr>
        <tr>
            <td><form:hidden path="id" />${propertyAndValueStringsForm.id}</td>
            <td><form:hidden path="name"/>${propertyAndValueStringsForm.name}</td>
            <td><form:hidden path="partNumber"/>${propertyAndValueStringsForm.partNumber}</td>
        </tr>
    </table>
    <br> <button type="submit" class="btn-lg btn-primary">Save</button>
    <table class="table table-hover">
        <tr class="active">
            <td>Property name</td>
            <td>Property value</td>
        </tr>
        <c:forEach items="${propertyAndValueStringsForm.propertyAndValue}" var="myMap" varStatus="status">
            <tr>
                <%--<td><form:hidden path="${myMap.key}"/>${myMap.key.propertyName}</td>--%>
                <td><input name="" value="${myMap.key.propertyName}" readonly></td>
                <td><input name="propertyAndValue[${myMap.key}]" value="${myMap.value.stringValue}"/></td>
            </tr>
        </c:forEach>
    </table>
</form:form>