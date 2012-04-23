<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tagging references</title>
    </head>
    <body>
        <h1>Tag a reference</h1>
        <p><c:if test="${not empty reference.tag}">Current tag: ${reference.tag}</c:if></p>
        <form:form commandName="tagForm" action="${pageContext.request.contextPath}/reference/${reference.id}/tag" method="POST">
            <form:input path="tag" /><form:errors path="tag" /> <br />
            <input type="submit" name="submit" value="submit"/>
        </form:form>
    </body>
</html>
