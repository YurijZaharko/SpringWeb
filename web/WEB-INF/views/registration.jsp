<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <div class="row">
        <c:if test="${param.fail}">
            <div class="col-md-12 col-xs-12">
                <p style="color: red;">Fail</p>
            </div>
        </c:if>
        <div class="col-md-4 col-md-offset-4">
            <form:form action="/registration" class="form-horizontal" method="post" modelAttribute="user">
                <form:hidden path="id"/>
                <div class="form-group">
                    <form:label path="login" cssClass="col-sm-4 control-label">Login</form:label>
                    <div class="col-sm-8">
                        <form:errors path="login" cssClass="alert-danger"/>
                        <form:input path="login" placeholder="Login" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="password" cssClass="col-sm-4 control-label">Password</form:label>
                    <div class="col-sm-8">
                        <form:errors path="password" cssClass="alert-danger"/>
                        <form:input path="password" placeholder="Password" cssClass="form-control" type="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="name" cssClass="col-sm-4 control-label">Name</form:label>
                    <div class="col-sm-8">
                        <form:errors path="name" cssClass="alert-danger"/>
                        <form:input path="name" placeholder="Name" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="surname" cssClass="col-sm-4 control-label">Surname</form:label>
                    <div class="col-sm-8">
                        <form:errors path="surname"/>
                        <form:input path="surname" placeholder="Surname" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="phoneNumber" cssClass="col-sm-4 control-label">Phone number</form:label>
                    <div class="col-sm-8">
                        <form:errors path="phoneNumber" cssClass="alert-danger"/>
                        <form:input path="phoneNumber" placeholder="Phone (123)456-7890" cssClass="form-control"/>
                    </div>
                </div>
                <form:hidden path="registrationDate"/>
                <button type="submit" class="btn btn-primary center-block">Registration</button>
            </form:form>
        </div>

    </div>
</div>

