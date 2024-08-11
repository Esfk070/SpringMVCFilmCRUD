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
    <h1>Here are your results:</h1>

    <c:if test="${not empty film}">
        <p>Title: ${film.title}</p>
        <p>Year: ${film.release_year}</p>
        <p>Rating: ${film.rating}</p>
        <p>Description: ${film.description}</p>

        <p>Cast:</p>
        <ul>
            <c:forEach var="actor" items="${film.filmCast}">
                <li>${actor.first_name} ${actor.last_name}</li>
            </c:forEach>
        </ul>

        <!-- UPDATEE -->
        <form action="updateFilm.do" method="get" style="display:inline;">
            <input type="hidden" name="filmId" value="${film.id}">
            <button type="submit">Update</button>
        </form>

        <!-- DELETE -->
        <form action="deleteFilm.do" method="post" style="display:inline;">
            <input type="hidden" name="filmId" value="${film.id}">
            <button type="submit">Delete</button>
        </form>
    </c:if>

</body>

</html>
