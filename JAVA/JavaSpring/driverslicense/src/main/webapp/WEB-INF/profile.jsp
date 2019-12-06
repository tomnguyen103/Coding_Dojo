<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile Page</title>
</head>
<body>
	<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
	<p><c:out value="${license.number}"/></p>
	<p><c:out value="${license.expirationDate}"/></p>
	<p><c:out value="${license.state}"/></p>
</body>
</html>