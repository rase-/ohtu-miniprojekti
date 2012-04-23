<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arto wants to add a reference</title>     
        <style type="text/css">
        label {
            width: 150px;
            float: left;
            margin: 2px 4px 6px 4px;
            text-align: right;
        }
        br { clear: left; }     
        </style>        
    </head>
    <body>
        <h1>Add a reference</h1>
        <label>&nbsp;</label><form:form commandName="reference" action="${pageContext.request.contextPath}/reference" method="POST">
            <form:select path="type">
                <form:option value="ARTICLE" label="Article" />
                <form:option value="BOOK" label="Book" />
                <form:option value="INPROCEEDINGS" label="Inproceedings" />
                <form:option value="MISC" label="Misc" />
            </form:select><br />
            <label for="author">Author: </label><form:input path="author" /><form:errors path="author" /><br/>
            <label for="title">Title: </label><form:input path="title" /><form:errors path="title" /><br/>
            <label for="year">Year: </label><form:input path="publishingYear" /><form:errors path="publishingYear" /><br/>
            <label for="publisher">Publisher: </label><form:input path="publisher" /><form:errors path="publisher" /><br/>
            <label for="pages">Pages: </label><form:input path="pages" /><form:errors path="pages" /><br/>
            <label for="address">Address: </label><form:input path="address" /><form:errors path="address" /><br/>
            <label for="booktitle">Booktitle: </label><form:input path="booktitle" /><form:errors path="booktitle" /><br/>
            <label for="journal">Journal: </label><form:input path="journal" /><form:errors path="journal" /><br/>
            <label for="volume">Volume: </label><form:input path="volume" /><form:errors path="volume" /><br/>
            <label for="number">Number: </label><form:input path="number" /><form:errors path="number" /><br/>
            <label for="note">Note: </label><form:input path="note" /><form:errors path="note" /><br/>
            <label>&nbsp;</label><input name="submit" type="submit" value="submit" />
        </form:form>
    </body>
</html>