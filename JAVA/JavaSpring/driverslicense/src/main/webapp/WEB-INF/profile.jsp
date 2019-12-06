<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile Page</title>
</head>
<body>
	<h1>Name: <c:out value="${license.person.firstName}"/> <c:out value="${license.person.lastName}"/></h1>
	<p>License Number: <c:out value="${license.number}"/></p>
	<p>Expiration Date: <fmt:formatDate pattern="MM-dd-yyyy" value="${license.expirationDate}"/></p>
	<p>State: <c:out value="${license.state}"/></p>
</body>
</html>