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
	<h1>Hello World!</h1>
	
	<h2>All Movies:</h2>
	
	<ul>
		<c:forEach items="${movies}" var="m">
			<li>
				<c:out value="${m.title}" />
			</li>
		</c:forEach>
	</ul>
	
	<form:form action="/movies" method="POST" modelAttribute="newMovie">
		<p>
			<form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:input path="description"/>
		</p>
		<input type="submit" value="Create"/>
	</form:form>	
</body>
</html>