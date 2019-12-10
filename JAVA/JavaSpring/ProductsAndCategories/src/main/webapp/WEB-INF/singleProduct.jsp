<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
	<div>
		<h1>Product: ${product.name} </h1>
		<h2>Categories:</h2>
		<ul>
			<c:forEach var="category" items="${product.categories}">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<form:form action="/addcategorytoproduct" method="POST" modelAttribute="cateProdObj">
			<h3>
				<form:label path="category">Add Category:</form:label>
				<form:select path="category">
					<c:forEach items="${categories}" var="cat">
						<form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
					</c:forEach>
				</form:select>
			</h3>
			<form:hidden path="product" value="${product.id}"/>
			<input type="submit" value="Add" />
		</form:form>
	</div>
</body>
</html>