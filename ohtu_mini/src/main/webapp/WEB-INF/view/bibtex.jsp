
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate BibTeX</title>
    </head>
    <body>
        <h1>Generate BibTeX</h1>
        <form:form commandName="fileform" action="${pageContext.request.contextPath}/bibtex" method="POST">
            Filename: <form:input path="filename" /><form:errors path="filename" />
            <input name="submit" type="submit" value="submit" />
        </form:form>
    </body>
</html>
