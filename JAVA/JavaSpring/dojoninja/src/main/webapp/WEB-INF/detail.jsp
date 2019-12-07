<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1><c:out value="${dojo.name}" /> Location Ninjas</h1>
	<c:forEach var="ninja" items="${dojo.ninjas}">
		<p>${ninja.firstName} ${ninja.lastName}, ${ninja.age}</p>
	</c:forEach>
</body>
</html>