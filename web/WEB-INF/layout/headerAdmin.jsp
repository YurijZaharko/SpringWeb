<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 21.08.2016
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Product <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/adminProduct">Create product</a></li>
                            <li><a href="">Load product from xls</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Brand<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/adminBrand">Create Brand</a></li>
                            <li><a href="">Second</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Category <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/adminCategory">Create Category</a></li>
                            <li><a href="/admin/adminStringProperties">Create string Properties</a></li>
                            <li><a href="/admin/adminIntegerProperties">Create Integer Property</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Country <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/adminCountry">Create Country</a></li>
                            <li><a href="">Second</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav col-md-3 col-md-offset-3">
                    <%--     <security:authentication property="principal.password"/> --%>
                    <li><a>${authUser.login}</a></li>
                    <security:authorize access="isAuthenticated()">
                        <li>
                            <form:form action="/logout" method="post"
                                       class="navbar-form navbar-right">
                                <button type="submit" class="btn btn-default">Logout</button>
                            </form:form>
                        </li>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                        <li>
                            <a class="btn btn-default" href="/login">Login</a>
                        </li>
                    </security:authorize>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>


