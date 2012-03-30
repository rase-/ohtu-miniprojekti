<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="refresh" content="0;url=<c:url value="/home" />">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>We have moved.</title>
    </head>
    <body>
        <h1>We have moved. Click <a href="${pageContext.request.contextPath}/home">here.</a>!</h1>
    </body>
</html>
