<%--
  Created by IntelliJ IDEA.
  User: SCIP
  Date: 14.08.2016
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h3>${message}</h3>
    <form action="/registration" method="post">
        <p>User Name: <input name="name" placeholder="Enter you name" >
        <p>Your Email: <input name="eMail" placeholder="Enter you mail">
        <p>Enter your password <input name="pass" placeholder="Enter you pass">
        <p><input type="submit" value="Реєстрація "/>
    </form>
</body>
</html>
