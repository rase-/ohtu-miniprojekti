
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arto wants to add a reference</title>
    </head>
    <body>
        <h1>Add a reference</h1>
        <form:form commandName="reference" action="${pageContext.request.contextPath}/reference" method="POST">
            <form:select path="type">
                <form:option value="ARTICLE" label="Article" />
                <form:option value="BOOK" label="Book" />
                <form:option value="INPROCEEDINGS" label="Inproceedings" />
            </form:select> <br />
            Author: <form:input path="author" /><form:errors path="author" /><br/>
            Title: <form:input path="title" /><form:errors path="title" /><br/>
            Year: <form:input path="publishingYear" /><form:errors path="publishingYear" /><br/>
            Publisher: <form:input path="publisher" /><form:errors path="publisher" /><br/>
            Pages: <form:input path="pages" /><form:errors path="pages" /><br/>
            Address: <form:input path="address" /><form:errors path="address" /><br/>
            Booktitle: <form:input path="booktitle" /><form:errors path="booktitle" /><br/>
            Journal: <form:input path="journal" /><form:errors path="journal" /><br/>
            Volume: <form:input path="volume" /><form:errors path="volume" /><br/>
            Number: <form:input path="number" /><form:errors path="number" /><br/>
            <input name="submit" type="submit" value="submit" />
        </form:form>
    </body>
</html>
