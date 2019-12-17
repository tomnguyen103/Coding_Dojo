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
	
	
	<div>
		<h2>Ideas:</h2>
		<table>
			<thead>
				<tr>
					<th>Idea</th>
					<th>Created By:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="idea" items="${ideas}">
				<tr>					
					<td>
						<a href="/ideas/${idea.id}"><c:out value="${idea.content}"/></a>				
					</td>
					<td>
						<c:out value="${idea.user.name}"/>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	
	<div><a href="/ideas/new">Create new Idea</a></div>
</body>
</html>