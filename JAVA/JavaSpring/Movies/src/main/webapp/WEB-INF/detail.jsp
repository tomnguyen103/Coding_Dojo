<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Demo</title>
</head>
<body>
	<h1><c:out value="${movie.title}" /></h1>
	<p>
		<c:out value="${movie.description}" />
	</p>
</body>
</html>