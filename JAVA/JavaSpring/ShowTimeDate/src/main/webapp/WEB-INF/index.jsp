<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Page</title>
		<script src="date.js"></script>
		<style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	<body>
		<div class="container">
			<a href="/date">Show Current Date</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/time">Show Current Time</a>
		</div>
	</body>
</html>