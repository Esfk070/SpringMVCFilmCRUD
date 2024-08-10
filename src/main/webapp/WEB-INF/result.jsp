<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Film - Result</title>
</head>

<body>
	<h1>	 H1 TAG WITHIN BODY	</h1>
	
	<h2>TAG WITHIN BODY H1 - RENAME</h2>

	<c:if test="${not empty film}">
		<p>Title: ${film.title}</p>
		<p>Year: ${film.release_year}</p>
		<p>Rating ${film.rating}</p>
		<p>Description: ${film.description}</p>
		
		<!-- JavaWeb>TagLibraries>JSTL-Map Iteration  -->
		<p>Cast ${film.title}</p>
			<ul>
       			<c:forEach var="actor" items="${film.actors}">
            			<li>${actors.name}</li>
        			</c:forEach>
    			</ul>
	
	</c:if>
	


</body>


</html>