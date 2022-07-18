<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
</head>
<body>
	<a href="/books">back to the shelves</a>
	<h1>Add a Book to Your Shelf!</h1>
	<form:form action="/books/processnew" method="post" modelAttribute="book">
  	<form:input type="hidden" path="user" value="${userId }"/>
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="author">Author</form:label>
        <form:errors path="author"/>
        <form:input path="author"/>
    </p>
    <p>
        <form:label path="thoughts">Thoughts</form:label>
        <form:errors path="thoughts"/>
        <form:textarea path="thoughts"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form> 
	

</body>
</html>