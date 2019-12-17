<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Idea</title>
</head>
<body>
	<h1>Edit <c:out value="${idea.content}"/></h1>
	<form:form action="/ideas/${idea.id}/edit" method="POST" modelAttribute="idea">
		<p>
	        <form:label path="content">Content</form:label>
	        <form:errors path="content"/>
	        <form:input path="content"/>
	    </p>
	    <form:hidden path="user" value="${user.id}"/>
	    <input type="submit" value="Submit"/>
	</form:form>
	<h2><a href="/ideas/${idea.id}/delete">Delete This Idea</a></h2>
</body>
</html>