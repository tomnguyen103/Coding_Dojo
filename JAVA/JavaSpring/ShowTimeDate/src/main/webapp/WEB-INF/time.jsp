<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Time</title>
		<script><%@include file="/WEB-INF/js/time.js"%></script>
		<style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	<body onload="timeMessage()">
		<div id="time">
			<h1>Current Time: <c:out value="${time}"/></h1><br>
			<a href="/">Go Back</a>
		</div>
	</body>
</html>