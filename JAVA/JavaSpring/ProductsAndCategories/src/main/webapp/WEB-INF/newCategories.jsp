<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Categories</title>
</head>
<body>
	<h1>New Category:</h1>
	<form:form action="/categories" method="POST" modelAttribute="category">
	<div>
		<form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
		
	</div>
	<br>
	<button>Create</button>
	</form:form>
</body>
</html>