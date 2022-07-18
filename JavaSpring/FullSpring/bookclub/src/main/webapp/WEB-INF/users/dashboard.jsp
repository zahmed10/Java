<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, ${user.userName}</h1>
	<h2>Books from everyone's shelves:</h2>
	<a href="/logout">Logout</a>
	<a href="/books/new">+Add a to my shelf</a>
	<table>
		<tr>
			<th>ID</th><th>Title</th>
			<th>Author Name</th><th>Posted By</th>
		
		</tr>
		<c:forEach items="${books }" var="book">
		<tr>
			<td>${ book.id}</td>
			<td><a href="/books/${book.id }">${ book.title}</a></td><td>${ book.author}</td>
			<td>${ book.user.userName}</td>
		</tr>
		</c:forEach>
	
	</table>

</body>
</html>