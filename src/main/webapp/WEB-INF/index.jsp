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
	<form action="getFilmById.do" method="get">
		Search by a film's ID: <input name="filmId" type="text" /><br /> <input
			type="submit" value="Submit" />
	</form>

	<!-- Film Keyword Form: Allows user to search for a film by keyword -->
	<form action="getFilmByKeyword.do" method="get">
		Search by keyword: <input name="keyword" type="text" /><br /> <input
			type="submit" value="Submit" />
	</form>

</body>

</html>