<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 05.01.2017
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form:form action="/admin/users" method="get" modelAttribute="filter" cssClass="form-inline">
                <custom:hiddenInputs excludeParams="search"/>
                <div class="form-group">
                    <form:input path="search" placeholder="search" />
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form:form>
        </div>
        <div class="col-md-1">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort ID <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="ID asc" paramValue="id"/>
                    <custom:sort innerHtml="ID desc" paramValue="id,desc"/>
                </ul>
            </div>
        </div>
        <div class="col-md-1">
            <custom:size posibleSizes="1,2,5,10" size="${allUsers.size}" title="Page size"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form:form action="/admin/users" method="post" class="form-inline" modelAttribute="user">
                <form:hidden path="id"/>

                <form:hidden path="registrationDate"/>
                <custom:hiddenInputs excludeParams="name, id"/>
                <div class="form-group">
                    <form:errors path="login"/>
                    <form:input path="login" placeholder="Login"/>
                </div>
                <div class="form-group">
                    <form:errors path="password"/>
                    <form:input path="password" placeholder="Password" type="password"/>
                </div>
                <div class="form-group">
                    <form:errors path="name"/>
                    <form:input path="name" placeholder="name"/>
                </div>
                <div class="form-group">
                    <form:errors path="surname"/>
                    <form:input path="surname" placeholder="Surname"/>
                </div>
                <div class="form-group">
                    <form:errors path="phoneNumber"/>
                    <form:input path="phoneNumber" placeholder="Phone Number"/>
                </div>
                <div class="form-group">
                    <form:select path="role">
                        <form:options/>
                    </form:select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
                </div>
            </form:form>
        </div>


    <table class="table table-hover">

        <tr>
            <td>#</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Phone number</td>
            <td>Registration date</td>
            <td>Role</td>
        </tr>
        <c:forEach items="${allUsers.content}" var="oneUser">
            <tr>
                <td>${oneUser.id}</td>
                <td>${oneUser.name}</td>
                <td>${oneUser.surname}</td>
                <td>${oneUser.phoneNumber}</td>
                <td>${oneUser.registrationDate}</td>
                <td>${oneUser.role}</td>
                <td><a href="/admin/users/delete/${oneUser.id}<custom:allParams/>" class="btn btn-danger">Delete</a> </td>
                <td><a href="/admin/users/update/${oneUser.id}<custom:allParams/>" class="btn btn-warning">Update</a></td>

            </tr>
        </c:forEach>
    </table>
    <div class="col-md-12 text-center">
        <custom:pageable page="${allUsers}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</div>
