<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table table-bordered">
			  	<thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Creator</th>
				      <th scope="col">Version</th>
				      <th scope="col">Action</th>
				    </tr>
			  	</thead>
			  	<tbody>
			  		<c:forEach items="${languages}" var="lang">
				    <tr>
				      <td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
				      <td><c:out value="${lang.creator}"/></td>
				      <td><c:out value="${lang.currentVersion}"/></td>
				      <td><a href="/languages/delete/<c:out value="${lang.id}"/>">Delete</a> | <a href="/languages/edit/<c:out value="${lang.id}"/>">Edit</a></td>
				    </tr>
				    </c:forEach>
			  	</tbody>
			</table>
		</div>
	
	
		<div class="row">
			<h2>New Language:</h2>
		</div>
		<div class="row">
			<form:form action="/create" method="post" modelAttribute="language">
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="name">Name</form:label>
			       <div class="col-md-10">
				       <form:errors path="name"/>
				       <form:input path="name"/>
				   </div>
			   </div>
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="creator">Creator</form:label>
			       <div class="col-md-10">
				       <form:errors path="creator"/>
				       <form:textarea path="creator"/>
				   </div>
			   </div>
			   <div class="form-group row">
			       <form:label class="col-md-2 col-form-label" path="currentVersion">Current Version</form:label>
			       <div class="col-md-10">
				       <form:errors path="currentVersion"/>
				       <form:input path="currentVersion"/>
				   </div>
			   </div> 
			   <input type="submit" value="Submit"/>
			</form:form>  
		</div>
	</div>
</body>
</html>