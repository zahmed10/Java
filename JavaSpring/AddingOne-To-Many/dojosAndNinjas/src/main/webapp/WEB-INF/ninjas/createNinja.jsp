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
	<h1>New Ninja</h1>
	<form:form action="/ninjas/createnew" method="post" modelAttribute="ninja">
		<p>
			Dojo: <form:select path="dojo">
				<option disabled selected value="">Select a Dojo</option>
				<c:forEach items="${dojosList }" var="d">
					<form:option value="${ d.getId()}">${d.getName() }</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"></form:errors>
			<form:input path="firstName"></form:input>
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"></form:errors>
			<form:input path="lastName"></form:input>
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:errors path="age"></form:errors>
			<form:input type="number" path="age"></form:input>
		</p>
		<button>Submit</button>
	</form:form>
	

</body>
</html>