<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>
<h1>Welcome to the Film Site </h1>


<!-- TODO form with filmID field and button, action = "getFilm.do" -->


<form action="getFilmById.do" method="get">
	FilmID: <input name = "filmId" type="text" /><br />
<input type = "submit" value="Submit" />
</form>

</body>
</html>