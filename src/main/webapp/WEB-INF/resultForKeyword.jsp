<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Films - Result</title>
</head>

<body>
<h1>	 Here are your list of films: </h1>
	
	
	

	<c:if test="${not empty films}">
		<c:forEach var="film" items="${films}">
			<p>Title: ${film.title}</p>
			<p>Year: ${film.release_year}</p>
			<p>Rating: ${film.rating}</p>
			<p>Description: ${film.description}</p>		
		
		<!-- JavaWeb>TagLibraries>JSTL-Map Iteration  -->
			<p>Cast: 
		 	 	<ul>
       				<c:forEach var="actor" items="${film.filmCast}">
            				<li>${actor.first_name}</li>
        				</c:forEach>
    				</ul>
<%-- 		 	 	<ul>
       				<c:forEach var="actor" items="${film.filmCast}">
            				<li>${actor.first_name}</li>
        				</c:forEach>
    				</ul> --%>
    			</p>
    	
		</c:forEach>
		
	</c:if>

</body>


</html>