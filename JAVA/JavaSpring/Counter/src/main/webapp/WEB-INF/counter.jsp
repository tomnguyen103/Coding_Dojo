<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current Visit Count</title>
</head>
<body>
	<div>
		<h1>You have visited <c:out value="${count}" /> times.</h1>
		<a href="/">Test Another User</a>
	</div>
	<div>
		<a href="/reset">Reset Counter</a>
	</div>

</body>
</html>