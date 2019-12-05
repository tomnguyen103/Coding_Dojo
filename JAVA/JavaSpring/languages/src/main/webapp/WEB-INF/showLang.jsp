<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Coding Language</title>
	
</head>
<body>

	<h1>Programing Language: <c:out value="${lang.name}"/></h1>
	<h1>Creator: <c:out value="${lang.creator}"/></h1>
	<h1>Current Version: <c:out value="${lang.currentVersion}"/></h1>
	
	<a href="/languages/edit/<c:out value="${lang.id}"/>">Edit</a><br>
	<a href="/languages/delete/<c:out value="${lang.id}"/>">Delete</a><br>
	<a href="/languages">DashBoard</a><br>
</body>
</html>