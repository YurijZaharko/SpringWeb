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
<form:form action="/admin/adminProduct/addValue" method="post" modelAttribute="oneProduct">
    <table class="table table-hover">
        <tr>
            <td>Product id</td>
            <td>Product name</td>
            <td>Product property</td>
            <td>Product value</td>
        </tr>
        <tr>
            <td>${oneProduct.id}</td>
            <td>${oneProduct.productName}</td>
            <td>${oneProduct.partNumber}</td>
            <c:forEach items="${properties}" var="propert">
                <td>${propert.name}</td>
            </c:forEach>
        </tr>
    </table>

</form:form>