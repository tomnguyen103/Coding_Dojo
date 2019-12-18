<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
</head>
<body>
	<h1>Edit <c:out value="${course.course_name}"/></h1>
	<a href="/courses">Dashboard</a> | <a href="/logout">Logout</a>
	
	<form:form action="/updateCourse" method="POST" modelAttribute="course">
		<form:input path="id" type="hidden"/>
		<form:input path="users" type="hidden"/>
		<p>
	        <form:errors path="course_name"/><br>
	        <form:label path="course_name">Name:</form:label>
	        <form:input path="course_name" type="text"/>
	    </p>
	    <p>
	        <form:errors path="instructor"/><br>
	        <form:label path="instructor">Instructor:</form:label>
	        <form:input path="instructor" type="text"/>
	    </p>
	    <p>
	        <form:errors path="capacity"/><br>
	        <form:label path="capacity">Capacity:</form:label>
	        <form:input path="capacity" type="number"/>
	    </p>
    	
    	<input type="submit" value="Update"/>
	</form:form>
	
</body>
</html>