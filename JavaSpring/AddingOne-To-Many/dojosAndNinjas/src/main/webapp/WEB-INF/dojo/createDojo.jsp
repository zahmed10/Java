<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/createnew" method="post" modelAttribute="dojo">
	<!-- <input type="hidden" name="_method" value="put"/> -->
	<p> <!-- New dojo form -->
		<!-- Form to add a new dojo -->
		<!-- Could also do <form:errors path="*" /> instead for the errors -->
		<form:label path="name">Name</form:label>
		<form:errors path="name"></form:errors>
		<form:input path="name"></form:input>
	</p>
	<button>Submit</button>
	</form:form>
</body>
</html>