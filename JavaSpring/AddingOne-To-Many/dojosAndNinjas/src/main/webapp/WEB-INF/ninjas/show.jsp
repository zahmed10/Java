<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${selectedDojo.getName() }"></c:out> Location Ninjas</h1>
	<table>
	<thead>
		<tr>
			<th>First Name</th><th>Last Name</th><th>Age</th>
		</tr>
			<c:forEach items="${selectedDojo.getNinjas() }" var="ninja">
				<tr>
				<td><c:out value="${ninja.getFirstName() }"></c:out></td>
				<td><c:out value="${ninja.getLastName() }"></c:out></td>
				<td><c:out value="${ninja.getAge() }"></c:out></td>
				</tr>
			</c:forEach>
		
	
	</thead>
	</table>
	
	

</body>
</html>