<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Vihavainen BibTeX service</title>
    </head>
    <body>
        <h1>The Vihavainen BibTeX - Reference service -- Le Home de Arto Vihavainen</h1>
        <p><a href="<c:url value="/reference"/>">Add</a> a reference</p>
        <p><a href="<c:url value="/reference/all"/>">List all</a> references</p> 
        <c:forEach var="reference" items="${references}">
            <p>${reference.type}: <c:if test="${not empty reference.author}">Author: ${reference.author}</c:if> <c:if test="${not empty reference.title}">, Title: ${reference.title}</c:if><c:if test="${not empty reference.publishingYear}">, Year: ${reference.publishingYear}</c:if><c:if test="${not empty reference.publisher}">, Publisher: ${reference.publisher}</c:if><c:if test="${not empty reference.pages}">, 
                    Pages: ${reference.pages}</c:if><c:if test="${not empty reference.address}">, Address: ${reference.address}</c:if><c:if test="${not empty reference.journal}">, Journal: ${reference.journal}</c:if><c:if test="${reference.volume > 0}">, Volume: ${reference.volume}</c:if><c:if test="${reference.number > 0}">, Number: ${reference.number}</c:if> <a href="deleteReference/${reference.id}" id="${reference.author}">poista</a>
                
            </p>
        </c:forEach>
    </body>
</html>
