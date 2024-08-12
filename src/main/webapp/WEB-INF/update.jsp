<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Update Film</title>
 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
    <div class="container mt-5 pb-5"> <!-- Added pb-5 for padding-bottom -->
        <h1 class="text-primary mb-4">Update Film Details</h1>
        
        <form action="updateFilm.do" method="post">
            <input type="hidden" name="filmId" value="${film.id}">
            
            <div class="mb-3">
                <label for="filmTitle" class="form-label">Title</label>
                <input type="text" class="form-control" id="filmTitle" name="filmTitle" value="${film.title}" required>
            </div>

            <div class="mb-3">
                <label for="filmDescription" class="form-label">Description</label>
                <input type="text" class="form-control" id="filmDescription" name="filmDescription" value="${film.description}">
            </div>

            <div class="mb-3">
                <label for="releaseYear" class="form-label">Release Year</label>
                <input type="number" class="form-control" id="releaseYear" name="releaseYear" value="${film.release_year}">
            </div>

            <div class="mb-3">
                <label for="languageId" class="form-label">Language ID</label>
                <input type="number" class="form-control" id="languageId" name="languageId" value="${film.language_id}" required>
            </div>

            <div class="mb-3">
                <label for="rentalDuration" class="form-label">Rental Duration</label>
                <input type="number" class="form-control" id="rentalDuration" name="rentalDuration" value="${film.rental_duration}" required>
            </div>

            <div class="mb-3">
                <label for="rentalRate" class="form-label">Rental Rate</label>
                <input type="number" step="0.01" class="form-control" id="rentalRate" name="rentalRate" value="${film.rental_rate}" required>
            </div>

            <div class="mb-3">
                <label for="length" class="form-label">Length</label>
                <input type="number" class="form-control" id="length" name="length" value="${film.length}">
            </div>

            <div class="mb-3">
                <label for="replacementCost" class="form-label">Replacement Cost</label>
                <input type="number" step="0.01" class="form-control" id="replacementCost" name="replacementCost" value="${film.replacement_cost}" required>
            </div>

            <div class="mb-3">
                <label for="rating" class="form-label">Rating</label>
                <input type="text" class="form-control" id="rating" name="rating" value="${film.rating}">
            </div>

            <div class="mb-3">
                <label for="specialFeatures" class="form-label">Special Features</label>
                <input type="text" class="form-control" id="specialFeatures" name="specialFeatures" value="${film.special_features}">
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-success">Update Film</button>
                <a href="deleteFilm.do?filmId=${film.id}" class="btn btn-danger">Delete Film</a>
                <a href="index.do" class="btn btn-primary">Return to Main Menu</a>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>

</html>
