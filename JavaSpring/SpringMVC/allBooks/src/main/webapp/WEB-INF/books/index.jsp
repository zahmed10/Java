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
	<h1>All Books</h1>
	<%-- <c:out value="${books}"></c:out> --%>
		<!-- table with all the books -->
		<table>
			<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of Pages</th>
			</tr>
			</thead>
		<!-- loop over all the books to show the details as in the wireframe! -->
		<c:forEach var="oneBook" items="${books}"> <!-- looping through the list of books in Model model -->
				<tbody>
				<tr>
					<!-- using getters to get all the book attributes we want to put in the table -->
					<td><c:out value="${oneBook.getId()}"></c:out></td>
					<td><c:out value="${oneBook.getTitle()}"></c:out></td>
					<td><c:out value="${oneBook.getLanguage()}"></c:out></td>
					<td><c:out value="${oneBook.getNumberOfPages()}"></c:out></td>
				</tr>
				</tbody>
		</c:forEach>
		</table>
</body>
</html>