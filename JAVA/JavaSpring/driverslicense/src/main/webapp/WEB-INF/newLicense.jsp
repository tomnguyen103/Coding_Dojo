<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/createLicense" method="POST">
	<div>
		<label>Person:</label>
		<input type="text" name="firstName">
	</div>
	<br>
	<div>
		<label>State:</label>
		<input type="text" name="lastName">
	</div>
	<br>
	<div>
		<label>Expiration Date:</label>
		<input type="date" name="lastName">
	</div>
	<br>
	<button>Create</button>
	</form:form>
</body>
</html>