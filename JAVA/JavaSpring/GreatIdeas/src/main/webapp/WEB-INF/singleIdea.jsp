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
	<h1><c:out value="${idea.content}"/></h1>
	<h2>Created by: <c:out value="${idea.user.name}"/></h2>
	
	<h2><a href="/ideas/${idea.id}/edit">Edit This Idea</a></h2>
	<h2><a href="/ideas/${idea.id}/delete">Delete This Idea</a></h2>
</body>
</html>