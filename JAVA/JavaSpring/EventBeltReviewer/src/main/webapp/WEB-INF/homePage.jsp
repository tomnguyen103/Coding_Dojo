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
	<title>Events</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1>
	<a href="/logout">Logout</a>
	
	<h2>Here are some of the events in your State:</h2>
	<c:if test="${inState.size() == 0}"><h3>There are no current events in your area</h3></c:if>
	<c:if test="${inState.size() > 0}">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="instate" items="${inState}">
					<tr>
						<td><a href="/events/${instate.id}"><c:out value="${instate.name}"/></a></td>
						<td><c:out value="${instate.date}"/></td>
						<td><c:out value="${instate.location}"/></td>
						<td><c:out value="${instate.user.firstName}"/></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>