<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="jakarta.tags.core" prefix="c" %>_-->
 <!--<%@ taglib uri="https://jakarta.ee/tags/core" prefix="c" %> -->

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Films - Result</title>

	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
	<div class="container mt-5">
		<h1 class="text-primary mb-4">Here is your list of films:</h1>

		<c:if test="${not empty films}">
			<div class="row">
				<c:forEach var="film" items="${films}">
					<div class="col-md-6 mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">${film.title}</h5>
								<h6 class="card-subtitle mb-2 text-muted">Year: ${film.release_year}</h6>
								<p class="card-text">Rating: ${film.rating}</p>
								<p class="card-text">Description: ${film.description}</p>
								<h6 class="card-subtitle mb-2 text-muted">Cast:</h6>
								<ul class="list-group list-group-flush">
									<c:forEach var="actor" items="${film.filmCast}">
										<li class="list-group-item">${actor.first_name} ${actor.last_name}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>

		<a href="index.do" class="btn btn-primary mt-4">Return to Main Menu</a>
	</div>

	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>

</html>
