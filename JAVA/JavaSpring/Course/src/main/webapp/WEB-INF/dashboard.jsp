<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<a href="/logout">Logout</a>
	
	<h2>Course List:</h2>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>Course</th>
					<th>Instructor</th>
					<th>Capacity</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
				<tr>					
					<td>
						<a href="/courses/${course.id}"><c:out value="${course.course_name}"/></a>				
					</td>
					<td>
						<c:out value="${course.instructor}"/>
					</td>
					<td>
						<c:out value="${course.capacity}"/>
					</td>
					<td><a href="/courses/add/${course.id}">Add</a></td>
				</tr>
				</c:forEach>				
			</tbody>
		</table>
	</div>
	
	<div><a href="/courses/new">Create new Course</a></div>
</body>
</html>