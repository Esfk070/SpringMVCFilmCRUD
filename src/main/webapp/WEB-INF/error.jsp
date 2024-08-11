<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">


<title>	SpringMVC Film Site - Error </title>

</head>

<body class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-danger mt-5">Error!</h1>
				<p class="alert alert-warning">${message}</p>
				<a href="index.do" class="btn btn-primary mt-3">Try again - Home</a>
			</div>
		</div>
	</div>

	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>

</html>
