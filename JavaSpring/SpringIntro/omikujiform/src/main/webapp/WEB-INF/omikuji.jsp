<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/omikuji.css" />
</head>
<body>
	<div class="container">
		<p class="par">In <c:out value="${number}"></c:out> years, you will live in 
		<c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as
		your roommate, <c:out value="${hobby}"></c:out> for a living. The next 
		time you see a <c:out value="${creature}"></c:out>, you will have good luck.
		Also, <c:out value="${comment}"></c:out></p>
		
		<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>