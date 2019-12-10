<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1>Single Category</h1>
	<div>
		<h1>Category: ${category.name} </h1>
		<h2>Product:</h2>
		<ul>
			<c:forEach var="product" items="${category.products}">
				<li>${product.name}</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<form:form action="/addproducttocategory" method="POST" modelAttribute="cateProdObj">
			<h3>
				<form:label path="product">Add Product:</form:label>
				<form:select path="product">
					<c:forEach items="${products}" var="prod">
						<form:option value="${prod.id}"><c:out value="${prod.name}"/></form:option>
					</c:forEach>
				</form:select>
			</h3>
			<form:hidden path="category" value="${category.id}"/>
			<input type="submit" value="Add" />
		</form:form>
	</div>
</body>
</html>