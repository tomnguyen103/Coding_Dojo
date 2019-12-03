<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Color Pick</title>
</head>
<body>
	<h1>Hello World</h1>
	<form action="/submit-form" method="POST">
		<label>Name</label>
		<input type="text" name="name">
		<label>Color</label>
		<input type="text" name="color">
		<button>Submit</button>
	</form>
	
	<c:out value="${inputtedName}" /><br>
	<c:out value="${inputtedColor}" />
	
	

</body>
</html>