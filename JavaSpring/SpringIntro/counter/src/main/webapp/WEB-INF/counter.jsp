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
	<p>You have visited <a href="/your_server">http://you_server</a> <c:out value="${countToShow}"></c:out> times</p>
	<a href="/your_server">Test another visit?</a>
</body>
</html>