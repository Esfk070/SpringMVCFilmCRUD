<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>MVC Film Site</title>
<style>
table {
	width: 75%;
	margin: 10px 0;
}

</head>

<body>
	<h1>Welcome to the SpringMVC Film Site</h1>

	<!-- Film ID Form: Allows user to search for a film by Film ID -->
	<h2>Search Film by ID</h2>
	<br />
	<form action="getFilmById.do" method="get">
		Search by a film's ID: <input name="filmId" type="text" /><br /> <input
			type="submit" value="Submit" />
	</form>
	<br />



	<!-- Film ID Form: Allows user to search for a film by Film ID -->
	<h2>Add Film to DataBase</h2>
	<form action="addFilm.do" method="post">
		
		Title: <input name="filmTitle" type="text" />

td {
	padding: 15px;
}

form {
	margin: 0;
}

input[type="text"], input[type="number"] {
	width: 100%;
	padding: 5px;
}
</style>

</head>

<body>
	<h1>Welcome to the SpringMVC Film Site!</h1>

	<!-- Delete FIlm Form: Allows user to search for a film by id -->
	<h2>Delete Film by ID</h2>
	<form action="deleteFilm.do" method="post">
		Delete by Film ID: <input name="filmId" type="text" /> <input
			type="submit" value="Submit" /><br />
	</form>

	<table>
		<tr>
			<td>
				<h2>Try searching for a film by ID!</h2>
				<form action="getFilmById.do" method="get">
					<label for="filmId">Enter the ID:</label> <input id="filmId"
						name="filmId" type="text" /> <input type="submit" value="Submit" />
				</form>
			</td>
			<td>
				<h2>You can also search for a film by keyword - try it out!</h2>
				<form action="getFilmByKeyword.do" method="get">
					<label for="keyword">Search by keyword:</label> <input id="keyword"
						name="keyword" type="text" /> <input type="submit" value="Submit" />
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h2>Or, you can try adding a film!</h2>
				<form action="addFilm.do" method="post">
					<table>
						<tr>
							<td><label for="filmTitle">Title:</label></td>
							<td><input id="filmTitle" name="filmTitle" type="text"
								required /></td>
						</tr>
						<tr>
							<td><label for="filmDescription">Description:</label></td>
							<td><input id="filmDescription" name="filmDescription"
								type="text" /></td>
						</tr>
						<tr>
							<td><label for="releaseYear">Release Year:</label></td>
							<td><input id="releaseYear" name="releaseYear" type="number" /></td>
						</tr>
						<tr>
							<td><label for="languageId">Language ID:</label></td>
							<td><input id="languageId" name="languageId" type="number"
								required /></td>
						</tr>
						<tr>
							<td><label for="rentalDuration">Rental Duration:</label></td>
							<td><input id="rentalDuration" name="rentalDuration"
								type="number" required /></td>
						</tr>
						<tr>
							<td><label for="rentalRate">Rental Rate:</label></td>
							<td><input id="rentalRate" name="rentalRate" type="number"
								step="0.01" required /></td>
						</tr>
						<tr>
							<td><label for="length">Length:</label></td>
							<td><input id="length" name="length" type="number" /></td>
						</tr>
						<tr>
							<td><label for="replacementCost">Replacement Cost:</label></td>
							<td><input id="replacementCost" name="replacementCost"
								type="number" step="0.01" required /></td>
						</tr>
						<tr>
							<td><label for="rating">Rating:</label></td>
							<td><input id="rating" name="rating" type="text" /></td>
						</tr>
						<tr>
							<td><label for="specialFeatures">Special Features:</label></td>
							<td><input id="specialFeatures" name="specialFeatures"
								type="text" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Submit" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>

</html>
