<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- additional tags to add -->
<%@ page isErrorPage="true" %>  
    <!-- form:label input -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <!-- for c tags -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/edit.css" />
</head>
<body>
	<%-- The id is <c:out value="${id }"></c:out> --%>
	<div class="top-container">
	
		<div>
			<h1>Edit Expense</h1>
		</div>
		<div>
			<a href="/expenses">Go back</a>
		</div>
	</div>
	<div>
		<form:form action="/expenses/${foundExpense.id}" method="post" modelAttribute="foundExpense"> <!-- my biggest error was here. i had expense instead of foundExpense
		so a mismatch in the variables caused me some problems. -->
		    <input type="hidden" name="_method" value="put"/> -->
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
		   <%--  <p>
		        <form:label path="id"></form:label>
		        <form:errors path="id"/>     
		        <form:input type="hidden" value="${id}" path="id"/>
		    </p>   --%>
		      
		    <input type="submit" value="Submit"/>
		</form:form>
	
	</div>
	

</body>
</html>