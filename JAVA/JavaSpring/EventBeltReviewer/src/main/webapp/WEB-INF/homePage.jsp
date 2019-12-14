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
	
	<div>
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
							<td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${instate.date}"/></td>
							<td><c:out value="${instate.location}"/></td>
							<td><c:out value="${instate.user.firstName}"/></td>
							<c:choose>
								<c:when test="${instate.user==user}">
									<td>Attening | <a href="/events/${instate.id}/edit">Edit</a> | <a href="/events/${instate.id}/delete">Delete</a></td>
								</c:when>
								<c:otherwise>
									<c:set var="attending" value="${false}"/>
									<c:forEach var="attendee" items="${instate.getJoinedUsers()}">
										<c:if test="${attendee == user}">
											<c:set var="attending" value="${true}"/>
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${attending==false}">
											<td><a href="/events/${instate.id}/join">Join</a></td>
										</c:when>
										<c:otherwise>
											<td>Attending | <a href="/events/${instate.id}">Cancel</a></td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div>
		<h2>Create an Event:</h2>
		<form:form method="POST" action="addEvent" modelAttribute="event">
			<h4>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name"></form:input>
			</h4>
			<h4>
				<form:label path="date">Date:</form:label>
				<form:input type="date" path="date"></form:input>
			</h4>
			<h4>
				<form:label path="location">Location:</form:label>
				<form:select path="state">
					<c:forEach var="state" items="${states}">
						<form:option value="${state}"><c:out value="${state}"/></form:option>
					</c:forEach>
				</form:select>
				<form:input type="text" path="location"></form:input>
			</h4>
			<form:hidden path="user" value="${user.id}"/>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>