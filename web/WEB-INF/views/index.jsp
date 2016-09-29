<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 14.08.2016
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<![endif]-->
<html>

  <body>

  <div class="container">
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

  </body>
</html>
