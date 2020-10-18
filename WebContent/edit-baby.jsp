<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Baby</title>
</head>
<body>
	<form action = "editBabyServlet" method = "post">
		Baby Name: <input type = "text" name = "babyName" value = "${babyToUpdate.babyName}">
		<input type = "hidden" name = "id" value = "${babyToUpdate.babyId}">
		<input type = "submit" value = "Save Edited Baby">
	</form>
</body>
</html>