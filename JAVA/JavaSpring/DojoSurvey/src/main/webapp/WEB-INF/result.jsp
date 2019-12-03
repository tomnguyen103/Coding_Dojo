<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey Index</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<table class="submit_info">
		<tr>
		    <th>Name:</th>
		    <td><c:out value="${inputtedName}" /></td>
		</tr>
		<tr>
		    <th>Location:</th>
		    <td><c:out value="${inputtedLocation}" /></td>
		</tr>
		<tr>
		    <th>Favorite Language:</th>
		    <td><c:out value="${inputtedLanguage}" /></td>
		</tr>
		<tr>
		    <th>Comment:</th>
		    <td><c:out value="${inputtedComment}" /></td>
		</tr>
            
	</table>
	<a href="/">Go Back</a>
</body>
</html>