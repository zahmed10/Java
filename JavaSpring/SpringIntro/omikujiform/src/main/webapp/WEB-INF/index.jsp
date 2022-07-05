<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h3>Send an Omikuji!</h3>
	<div class="form">
    <form action='/login' method='POST'>
    <div class="input-field">
	<label>Pick any number from 5 to 25:</label>
    	<select name="number">
    		<c:forEach var="oneNum" items="${numsFromMyController}">
    		<option><c:out value="${oneNum}"></c:out></option>
    		</c:forEach>
    	</select>
    </div>
    <div class="input-form">
    	<label>Enter the name of any city.</label>
    	<input type="text" name="city" />
    </div>
    <div class="input-form">
    	<label>Enter the name of any real person</label>
    	<input type="text" name="person"  />
    </div>
    <div class="input-form">
    	<label>Enter professional endeavor or hobby:</label>
    	<input type="text" name="hobby"  />
    </div>
    <div class="input-form">
    	<label>Enter any type of living thing.</label>
    	<input type="text" name="creature"  />
    </div>
    <div class="input-form">
    	<label>Say something nice to someone:</label>
    	<textarea name="comment" id="" cols="30" rows="10"></textarea>
    </div>
    <div class="input-field">
    	<label>Send and show a friend</label>
    	<input type='submit' value='Send'>
    </div>
    </form>
	</div>

</body>
</html>