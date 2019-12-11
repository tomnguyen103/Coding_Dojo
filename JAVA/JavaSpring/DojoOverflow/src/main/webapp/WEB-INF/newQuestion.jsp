<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form:form action="/addQuestion" method="POST" modelAttribute="question">
	<div>
		<form:label path="question">Question: </form:label>
        <form:errors path="question"/>
        <form:textarea path="question"></form:textarea>
	</div>
	<br>
	<div>
		<form:label path="tags">Tag: </form:label>
        <form:errors path="tags"/>
        <form:textarea path="tags"></form:textarea>
	</div>
	<button>Submit</button>
	</form:form>
</body>
</html>