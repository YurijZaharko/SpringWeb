<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 17.08.2016
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <meta charset="utf-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
    <div>
        <tiles:insertAttribute name="body"/>
    </div>
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>
</body>
</html>
