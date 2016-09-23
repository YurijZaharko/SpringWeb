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


  <h1>Hello</h1>
  <security:authorize access="!isAuthenticated()">
    <a href="/registration">Register</a>
    <a href="/login">Login</a>
  </security:authorize>
  <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
    <a href="/admin">Admin panel</a>
  </security:authorize>


  </body>
</html>
