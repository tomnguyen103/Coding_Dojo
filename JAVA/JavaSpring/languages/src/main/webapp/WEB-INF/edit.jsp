<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
			<h2>Edit Language:</h2>
		</div>
		<div class="row">
			<form:form action="/" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="name">Name</form:label>
			       <div class="col-md-8">
				       <form:errors path="name"/>
				       <form:input path="name"/>
				   </div>
			   </div>
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="creator">Creator</form:label>
			       <div class="col-md-8">
				       <form:errors path="creator"/>
				       <form:textarea path="creator"/>
				   </div>
			   </div>
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="currentVersion">Current Version</form:label>
			       <div class="col-md-8">
				       <form:errors path="currentVersion"/>
				       <form:input path="currentVersion"/>
				   </div>
			   </div> 
			   <input type="submit" value="Edit"/>
			</form:form>  
		</div>
	</div>
</body>
</html>