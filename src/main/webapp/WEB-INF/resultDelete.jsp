<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Film Deletion Result</title>

	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
	<div class="container mt-5">
		<h1 class="text-danger mb-4">Film Deletion Result</h1>

		<c:if test="${not empty message}">
			<p class="alert alert-success">${message}</p>
		</c:if>
	
		<c:if test="${not empty error}">
			<p class="alert alert-danger">${error}</p>
		</c:if>

		<a href="index.do" class="btn btn-primary mt-3">Try again - Home</a>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>

</html>
