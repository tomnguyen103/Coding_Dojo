<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/createPerson" method="POST">
	<div>
		<label>First Name:</label>
		<input type="text" name="firstName">
	</div>
	<br>
	<div>
		<label>Last Name:</label>
		<input type="text" name="lastName">
	</div>
	<br>
	<button>Create</button>
	</form:form>
</body>
</html>