<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        
         <form:form commandName="findByTag" action="${pageContext.request.contextPath}/findByTag" method="POST">
         Find references by tag <form:input path="tag" /><form:errors path="tag" />
          <input type="submit" name="submit" value="find"/>
         </form:form>
    
        <p><a href=<c:url value="/reference/bibtex" />>Generate BibTeX</a></p>
        <c:forEach var="reference" items="${references}">

            <p>${reference.type}: <c:if test="${not empty reference.author}">Author: ${reference.author}</c:if> <c:if test="${not empty reference.title}">, Title: ${reference.title}</c:if><c:if test="${not empty reference.publishingYear}">, Year: ${reference.publishingYear}</c:if><c:if test="${not empty reference.publisher}">, Publisher: ${reference.publisher}</c:if><c:if test="${not empty reference.pages}">, 


                    Pages: ${reference.pages}</c:if><c:if test="${not empty reference.address}">, Address: ${reference.address}</c:if><c:if test="${not empty reference.journal}">, Journal: ${reference.journal}</c:if><c:if test="${reference.volume > 0}">, Volume: ${reference.volume}</c:if><c:if test="${reference.number > 0}">, Number: ${reference.number}</c:if><c:if test="${not empty reference.note}">, Note: ${reference.note}</c:if><c:if test="${not empty reference.tag}">, Tag: ${reference.tag}</c:if> <a href=<c:url value="/reference/${reference.id}/tag" />>tag</a> <a href=<c:url value="/deleteReference/${reference.id}" /> id="${reference.author}">delete</a>

                
            </p>
        </c:forEach>   
    </body>
</html>
