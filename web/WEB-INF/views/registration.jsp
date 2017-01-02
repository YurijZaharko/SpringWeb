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
        <form:form action="/registration" class="form-group" method="post" modelAttribute="user">
            <form:hidden path="id"/>
            <div class="form-group">
                <form:errors path="login"/>
                <form:input path="login" placeholder="login" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <input name="password" type="password" placeholder="Some like ***" class="form-control" />
            </div>
            <div class="form-group">
                <input name="name" placeholder="Name" class="form-control" />
            </div>
            <div class="form-group">
                <input name="surname" placeholder="Surname" class="form-control" />
            </div>
            <div class="form-group">
                <input name="phoneNumber" placeholder="Phone number" class="form-control" />
            </div>
            <form:hidden path="registrationDate"/>
            <button type="submit" class="btn btn-primary">Ok</button>
        </form:form>
    </div>
</div>

