<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HomePage</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Number Game:</h1>
				<p>Total Gold: <c:out value="${totalGold}" /></p>
			</div>
			<div class="w-100"></div>
			<div class="col-md-3 border">
				<div class="text-center">
					<h1 class="display-4">Farm</h1>
					<p>(Earn 10-20 golds)</p>
				</div>
				
				<form action="/process_money" method="POST">
					<input type="hidden" value="farm" name="client_choice">
					<input type="submit" value="Find gold">
				</form>	
			</div>
			
			<div class="col-md-3 border">
				<div class="text-center">
					<h1 class="display-4">Cave</h1>
					<p>(Earns 5-10 golds)</p>
				</div>
				<form action="/process_money" method="POST">
					<input type="hidden" value="cave" name="client_choice">
					<input type="submit" value="Find gold">
				</form>	
			</div>
			
			<div class="col-md-3 border">
				<div class="text-center">
					<h1 class="display-4">House</h1>
					<p>(Earns 2-5 golds)</p>
				</div>
				<form action="/process_money" method="POST">
					<input type="hidden" value="house" name="client_choice">
					<input type="submit" value="Find gold">
				</form>	
			</div>
			
			<div class="col-md-3 border">
				<div class="text-center">
					<h1 class="display-4">Casino</h1>
					<p>(Earns/takes 0-50)</p>
				</div>
				<form action="/process_money" method="POST">
					<input type="hidden" value="casino" name="client_choice">
					<input type="submit" value="Find gold">
				</form>	
			</div>
			<div class="w-100"></div>
			
		</div>
	</div>
</body>
</html>