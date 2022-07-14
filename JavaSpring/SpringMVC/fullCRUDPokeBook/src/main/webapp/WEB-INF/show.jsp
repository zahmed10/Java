<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out tag dependency -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expenses">Go back</a>
	<div>
		<p>Expense Name: <c:out value="${showExpense.name}"/></p>
		<p>Expense Description: <c:out value="${showExpense.description}"/></p>
		<p>Vendor: <c:out value="${showExpense.vendor}"/></p>
		<p>Amount Spent: <c:out value="${showExpense.amount}"/></p>
	
	</div>
	<%-- <c:out value="${ showExpense}"></c:out> --%>

</body>
</html>