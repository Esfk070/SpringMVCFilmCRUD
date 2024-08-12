<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>MVC Film Site</title>

	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
	<div class="container mt-5">
		<h1 class="text-center mb-4">Welcome to the SpringMVC Film Site!</h1>

		<div class="row">
			<div class="col-md-6">
				<h2>Search Film by ID</h2>
				<form action="getFilmById.do" method="get" class="form-inline">
					<div class="form-group mb-2">
						<label for="filmId" class="sr-only">Film ID</label>
						<input id="filmId" name="filmId" type="text" class="form-control mr-2" placeholder="Enter Film ID">
					</div>
					<button type="submit" class="btn btn-primary mb-2">Submit</button>
				</form>
			</div>
			<div class="col-md-6">
				<h2>Search Film by Keyword</h2>
				<form action="getFilmByKeyword.do" method="get" class="form-inline">
					<div class="form-group mb-2">
						<label for="keyword" class="sr-only">Keyword</label>
						<input id="keyword" name="keyword" type="text" class="form-control mr-2" placeholder="Enter Keyword">
					</div>
					<button type="submit" class="btn btn-primary mb-2">Submit</button>
				</form>
			</div>
		</div>

		<div class="mt-4">
			<h2>Add Film to Database</h2>
			<form action="addFilm.do" method="post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="filmTitle">Title</label>
						<input id="filmTitle" name="filmTitle" type="text" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="filmDescription">Description</label>
						<input id="filmDescription" name="filmDescription" type="text" class="form-control">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="releaseYear">Release Year</label>
						<input id="releaseYear" name="releaseYear" type="number" class="form-control">
					</div>
					<div class="form-group col-md-4">
						<label for="languageId">Language ID</label>
						<input id="languageId" name="languageId" type="number" class="form-control" required>
					</div>
					<div class="form-group col-md-4">
						<label for="rentalDuration">Rental Duration</label>
						<input id="rentalDuration" name="rentalDuration" type="number" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="rentalRate">Rental Rate</label>
						<input id="rentalRate" name="rentalRate" type="number" step="0.01" class="form-control" required>
					</div>
					<div class="form-group col-md-4">
						<label for="length">Length</label>
						<input id="length" name="length" type="number" class="form-control">
					</div>
					<div class="form-group col-md-4">
						<label for="replacementCost">Replacement Cost</label>
						<input id="replacementCost" name="replacementCost" type="number" step="0.01" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="rating">Rating</label>
						<input id="rating" name="rating" type="text" class="form-control">
					</div>
					<div class="form-group col-md-6">
						<label for="specialFeatures">Special Features</label>
						<input id="specialFeatures" name="specialFeatures" type="text" class="form-control">
					</div>
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
			</form>
		</div>

		<div class="mt-4">
			<h2>Delete Film by ID</h2>
			<form action="deleteFilm.do" method="post" class="form-inline">
				<div class="form-group mb-2">
					<label for="filmIdDelete" class="sr-only">Film ID</label>
					<input id="filmIdDelete" name="filmId" type="text" class="form-control mr-2" placeholder="Enter Film ID">
				</div>
				<button type="submit" class="btn btn-danger mb-2">Submit</button>
			</form>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
