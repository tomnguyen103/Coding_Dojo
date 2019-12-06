<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/add-license" method="POST" modelAttribute="license">
		<div>
	        <form:errors path="person"/>
			<form:label path="person">Person:</form:label>
			<form:select path="person">
				<c:forEach items="${personList}" var="person">
					<form:option value="${person.id}"><c:out value="${person.firstName}${person.lastName}"/></form:option>
				</c:forEach>
			</form:select>
		</div>
		<br>
		<div>
	        <form:errors path="state"/>
			<form:label path="state">State:</form:label>
	        <form:select path="state">
	        	<c:forEach items="${states}" var="state">
	        		<form:option value="${state}"><c:out value="${state}"/></form:option>
	        	</c:forEach>
	        </form:select>
		</div>
		<br>
		<div>
	        <form:errors path="expirationDate"/>
			<form:label path="expirationDate">Expiration Date:</form:label>
	        <form:input type="date" path="expirationDate"/>
		</div>
		<br>
		<button>Create</button>
	</form:form>
</body>
</html>