<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Film - Result</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
	<div class="container mt-5">
		<h1 class="text-primary mb-4">Here are your results:</h1>

		<c:if test="${not empty film}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Title: ${film.title}</h5>
					<p class="card-text"><strong>Year:</strong> ${film.release_year}</p>
					<p class="card-text"><strong>Rating:</strong> ${film.rating}</p>
					<p class="card-text"><strong>Description:</strong> ${film.description}</p>
					
					<h6 class="mt-3">Cast:</h6>
					<ul class="list-group list-group-flush">
						<c:forEach var="actor" items="${film.filmCast}">
							<li class="list-group-item">${actor.first_name} ${actor.last_name}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</c:if>

		<!-- Buttons Section -->
		<div class="mt-4">
			<a href="index.do" class="btn btn-primary">Return to Main Menu</a>
			
			<form action="deleteFilm.do" method="POST" class="d-inline">
				<input type="hidden" name="filmId" value="${film.id}" /> 
				<input type="submit" value="Delete Film" class="btn btn-danger" />
			</form>

			<form action="showUpdateForm.do" method="GET" class="d-inline">
				<input type="hidden" name="filmId" value="${film.id}" />
				<input type="submit" value="Update Film" class="btn btn-warning" />
			</form>
		</div>
	</div>

	</br>
		


	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>

</html>
