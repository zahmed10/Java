<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- additional tags to add -->
<%@ page isErrorPage="true" %>  
    <!-- form:label input -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Full CRUD PokeBook</title>
</head>
<body>
	<!-- table that lists all expenses -->
	<h1>PokeBook</h1>
	<!-- table with all the books -->
		<table>
			<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="expense" items="${lists}">
			<tr>
			
				<td><a href="/expenses/show/${expense.id }"><c:out value="${expense.name}"/></a></td>
				<td><c:out value="${expense.vendor}"/></td>
				<td><c:out value="${expense.amount}"/></td>
				<td><a href="/expenses/edit/<c:out value="${expense.id}"/>">Edit</a></td>
				<td>
					<form action="/expenses/delete/${expense.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<!-- form to add new expenses -->
		<h2>Track an expense:</h2>
		<form:form action="/process" method="post" modelAttribute="expense">
		    <p>
		        <form:label path="name">Title</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea path="description"/>
		    </p>
		    <p>
		        <form:label path="vendor">Vendor</form:label>
		        <form:errors path="vendor"/>
		        <form:input path="vendor"/>
		    </p>
		    <p>
		        <form:label path="amount">Amount</form:label>
		        <form:errors path="amount"/>     
		        <form:input type="number" path="amount"/>
		    </p>    
		    <input type="submit" value="Submit"/>
		</form:form>

</body>
</html>