<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Film Deletion Result</title>
</head>

<body>
	<h1>Film Deletion Result</h1>

	<c:if test="${not empty message}">
		<p style="color:green;">${message}</p>
	</c:if>
	
	<c:if test="${not empty error}">
		<p style="color:red;">${error}</p>
	</c:if>

	<a href="index.do">Try again - Home</a>

</body>

</html>
