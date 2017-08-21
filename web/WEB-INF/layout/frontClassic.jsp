<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 01.09.2016
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid top-background">
    <nav class="container top-second">
        <div class="row top-second">
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                <div class="row">
                    <div class="btn-group">
                        <button class="btn btn-link" type="button"  aria-label="Left Align"><span  class="fa fa-money fa-fw" aria-hidden="true"></span>Оплата</button>
                        <button class="btn btn-link" type="button"><i class="fa fa-truck fa-fw" aria-hidden="true"></i>Доставка</button>
                        <button class="btn btn-link" type="button"><i class="fa fa-phone-square fa-fw" aria-hidden="true"></i>Контакти</button>
                        <button class="btn btn-link" type="button"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>Про нас</button>
                    </div>
                </div>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-5 col-sm-offset-5 col-md-offset-5 col-lg-offset-5">
                <div class="row">
                    <div class="form-inline">
                        <security:authorize access="!isAuthenticated()">
                            <a href="/registration" class="btn btn-primary">Register</a>
                        </security:authorize>

                        <security:authorize access="!isAuthenticated()">
                            <a href="/login" class="btn btn-primary">Login</a>
                        </security:authorize>

                        <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                            <a href="/admin" class="btn btn-primary">Admin panel</a>
                        </security:authorize>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <div class="row" >
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <h2 class="">LOGO</h2>
        </div>
    </div>
</div>
<div class="container">
    <form:form action="/" method="get" modelAttribute="categories">
        <c:forEach items="${categories}" var="parentCategory">
            <div class="btn-group">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${parentCategory.name} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach items="${parentCategory.categoryChild}" var="childCategory">
                        <li><a href="/category/${childCategory.id}">${childCategory.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </c:forEach>
    </form:form>
</div>

