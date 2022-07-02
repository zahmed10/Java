<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="oneFruit" items="${fruitsFromMyController}">
		<tr>
			<td>
				<c:out value="${oneFruit.getName()}"></c:out>
			</td>
			<td>
				<c:out value="${oneFruit.getPrice()}"></c:out>
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>