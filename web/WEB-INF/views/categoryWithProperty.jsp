<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 11.09.2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form:form action="/admin/adminCategory/categoryWithProperty" method="post" modelAttribute="category">
        <%--<div class="form-group">--%>
            <%--<input type="submit" class="btn btn-primary" placeholder="Add">--%>
        <%--</div>--%>
        <%--<form:hidden path="id"/>--%>
        <%--<form:hidden path="name"/>--%>
        <%--<div class="form-group">--%>
            <%--&lt;%&ndash;<form:select path="name" items="${categoriesWithProperty}" class="form-control" itemLabel="name" itemValue="id"/>&ndash;%&gt;--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<form:select path="stringPropertiesList" items="${stringProperties}" itemLabel="propertyName" itemValue="id"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<form:select path="integerPropertiesList" items="${integerProperties}" itemLabel="name" itemValue="id"/>--%>
        <%--</div>--%>
        <div class="col-md-6">
            <table class="table table-hover">
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Add</td>
                </tr>
                <c:forEach items="${stringProperties}" var="stringProperty">
                    <tr>
                        <td>${stringProperty.id}</td>
                        <td>${stringProperty.propertyName}</td>
                        <td><a href="/admin/adminCategory/categoryWithProperty/propertyId/${category.id}/${stringProperty.id}" class="btn btn-primary">Add</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-6">
            <table class="table table-hover">
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Remove</td>
                </tr>
                <c:forEach items="${category.stringPropertiesList}" var="stringPropertiesList">
                    <tr>
                        <td>${stringPropertiesList.id}</td>
                        <td>${stringPropertiesList.propertyName}</td>
                        <td><a href="/admin/adminCategory/categoryWithProperty/removePropertyId/${category.id}/${stringPropertiesList.id}" class="btn btn-danger">Remove</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>



    </form:form>
</div>