<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Secret Code</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Welcome!</h1>
	<div class="container">
		<h2><c:out value="${error}" /></h2>
		<h1>What is the code?</h1>
		<form action="submit-form" method="POST">
			<input type="text" name="code">
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>