<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Vihavainen BibTeX service</title>
    </head>
    <body>
        <h1>All references</h1>
        <c:forEach var="reference" items="${references}">
            <p>${reference.type}: Author: ${reference.author}, Title: ${reference.title}, Year: ${reference.publishingYear}, Publisher: ${reference.publisher}, Pages: ${reference.pages}, Address: ${reference.address}, Journal: ${reference.journal}, Volume: ${reference.volume}, Number: ${reference.number}</p>
        </c:forEach>
    </body>
</html>