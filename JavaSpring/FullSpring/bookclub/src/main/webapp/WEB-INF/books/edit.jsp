<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- additional tags to add -->
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
   

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/books">back to the shelves</a>
	<form:form action="/books/${book.id }/processedit" method="post" modelAttribute="book">
  	<input type="hidden" name="_method" value="put">
  		<form:input type="hidden" path="user"/>
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