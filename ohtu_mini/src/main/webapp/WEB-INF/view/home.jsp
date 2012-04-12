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
        <p><a href="<c:url value="/reference"/>">Add</a> a reference</p>
        <p><a href="<c:url value="/reference/all"/>">List all</a> references</p> 
        <c:forEach var="reference" items="${references}">
            <p>${reference.type}: Author: ${reference.author}, Title: ${reference.title}, Year: ${reference.publishingYear}, Publisher: ${reference.publisher}, 
                Pages: ${reference.pages}, Address: ${reference.address}, Journal: ${reference.journal}, Volume: ${reference.volume}, Number: ${reference.number}, <a href="deleteReference/${reference.id}">poista</a><
                
            </p>
        </c:forEach>
    </body>
</html>
