<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
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

<!--  		Description:  <input name="filmDescription" type="text" /> -->

<!-- 		Release Year:  <input name="releaseYear" type="text" />  -->

		Language ID: <input name="languageId" type="text" /> 
		
		Rental Duration:
		<input name="rentalDuration" type="text" /> 
		
		Rental Rate: <input
			name="rentalRate" type="text" />

<!-- 		Length:  <input name="releaseYear" type="text" /> -->

		Replacement Cost: <input name="replacementCost" type="text" /> <input
			type="submit" value="Submit" /><br />
	

<!-- 		Rating:  <input name="rating" type="text" /> <input
			type="submit" value="Submit" /><br /> 

		Special Features:  <input name="speacialFeatures" type="text" /> <input
			type="submit" value="Submit" /><br /> -->
 
	</form>
	<br />


	<!-- Delete FIlm Form: Allows user to search for a film by id -->
	<h2>Delete Film by ID</h2>
	<form action="deleteFilm.do" method="post">
		Delete by Film ID: <input name="filmId" type="text" /> <input
			type="submit" value="Submit" /><br />
	</form>
	
	
	
	<!-- Film Keyword Form: Allows user to search for a film by keyword -->
	<h2>Search for Film by Keyword</h2>
	<form action="getFilmByKeyword.do" method="get">
		Search by keyword: <input name="keyword" type="text" /> <input
			type="submit" value="Submit" /><br />
	</form>

</body>

</html>