<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/books">back to the shelves</a>
	<h1>${foundBook.title }</h1>
	<h2>${foundBook.user.userName } read ${foundBook.title } by 
	${foundBook.author }</h2>
	<h3>Here are ${foundBook.user.userName }'s thoughts</h3>
	<p>${foundBook.thoughts }</p>
	<c:if test = "${userId == foundBook.user.id}">
		<a href="/books/${foundBook.id }/edit">edit</a>
    </c:if>
</body>
</html>