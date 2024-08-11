<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Film - Result</title>
</head>

<body>
	<h1>Here are your results:</h1>

	<c:if test="${not empty film}">
		<p>Title: ${film.title}</p>
		<p>Year: ${film.release_year}</p>
		<p>Rating: ${film.rating}</p>
		<p>Description: ${film.description}</p>

		<!-- JavaWeb>TagLibraries>JSTL-Map Iteration  -->
		<p>Cast:</p>
		<ul>
			<c:forEach var="actor" items="${film.filmCast}">
				<li>${actor.first_name}${actor.last_name}</li>
			</c:forEach>
		</ul>
	</c:if>
	<!--  -->
	
<!-- 	
	<input type="button" name="name" value="Delete Film"
		formaction="deleteFilm.do">
		 -->

	<form action="deleteFilm.do" method="POST">
		Delete Film: <input type="hidden" name="filmId" value="${film.id}" /> 
		<input type="submit" value ="Delete Film"  />
	</form>
 
</body>

</html>