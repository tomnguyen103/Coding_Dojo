<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
</head>
<body>
	<h1><c:out value="${course.course_name}"/></h1>
	<h2>Instructor: <c:out value="${course.instructor}"/></h2>
	<h2>Sign up: ${course.getUsers().size()}</h2>
	
	<table>
		<thead>
			<tr>
				<td>Student Name:</td>
				<td>Sign Up Date:</td>
				<td>Action:</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${course.getUsers()}">
			<tr>
				<td>${user.name}</td>
				<td><fmt:formatDate value="${user.createdAt}" pattern="MM/dd/yyyy HH:mm:ss a"/></td>
				<td>Remove</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2><a href="/courses/${course.id}/edit">Edit</a></h2>
	<h2><a href="/courses/${course.id}/delete">Delete</a></h2>
	<h2><a href="/courses">Back</a></h2>
</body>
</html>