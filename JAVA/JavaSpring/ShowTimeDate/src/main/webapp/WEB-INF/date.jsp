<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Date</title>
		<script><%@include file="/WEB-INF/js/date.js"%></script>
		<style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	<body onload="message()">
		<div id="date">
			<h1>Current Date: <c:out value="${date}"/></h1><br>
			<a href="/">Go Back</a>		
		</div>
	</body>
</html>