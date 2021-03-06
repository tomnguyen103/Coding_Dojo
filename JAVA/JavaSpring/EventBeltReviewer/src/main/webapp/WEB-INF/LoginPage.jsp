<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
	
	<div>
	    <h1>Register!</h1>
	    
	    <p><form:errors path="user.*"/></p>
	    
	    <form:form method="POST" action="/registration" modelAttribute="user">
	    	<p>
	            <form:label path="firstName">First Name:</form:label>
	            <form:input type="firstName" path="firstName"/>
	        </p>
	        <p>
	            <form:label path="lastName">Last Name:</form:label>
	            <form:input type="lastName" path="lastName"/>
	        </p>
	        <p>
	            <form:label path="location">Location:</form:label>
	            <form:select path="state">
	            	<c:forEach var="state" items="${states}">
	            		<form:option value="${state}"><c:out value="${state}"/></form:option>
	            	</c:forEach>
	            </form:select>
	            <form:input type="location" path="location"/>
	        </p>
	        <p>
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">PW Conf:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        <input type="submit" value="Register!"/>
	    </form:form>  
    </div>
    
	<div>
	    <h1>Login</h1>
	    <p><c:out value="${error}" /></p>
	    <form method="post" action="/login">
	        <p>
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="submit" value="Login!"/>
	    </form>  
   	</div>
   	
   	
</body>
</html>