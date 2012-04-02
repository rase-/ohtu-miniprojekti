<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Vihavainen BibTeX service</title>
    </head>
    <body>
        <h1>Le home de Arto Vihavainen.</h1>
        <c:forEach var="reference" items="${references}">
            <p>${reference.author}</p>
        </c:forEach>
    </body>
</html>
