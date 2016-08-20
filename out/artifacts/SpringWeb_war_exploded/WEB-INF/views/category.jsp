<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 15.08.2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">

<body>
    <ul>
        <li><a href="/category/product">First category</a></li>
        <li><a href="/category/product">Second category</a></li>
        <li><a href="/category/product">Third category</a></li>
        <li><a href="/category/product">Forth category</a></li>
    </ul>
        <h4>Category</h4>
    <table class="table">
        <tr>
            <th>Category name</th>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.name}</td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
