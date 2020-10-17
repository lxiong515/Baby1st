<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new event</title>
</head>
<body>
	<form action = "addEventServlet" method = "post">
		Event Name: <input type = "text" name = "eventName"><br />
		Event Date: <input type = "text" name = "month" placeholder = "mm" size = "4"> <input type = "text" name = "day" placeholder = "dd" size = "4">, <input type = "text" name = "year" placeholder = "yyyy" size = "4"><br />
		Baby: <input type = "text" name = "baby"><br />
		<table>
			<c:forEach items = "${requestScope.allBabies}" var = "eventDetails">
			<tr>
				<td><input type = "radio" name = "id" value = "${eventDetails.babyId}"></td>
				<td>${eventDetails.eventId}</td>
				<td>${eventDetails.baby}</td>
				<td>${eventDetails.eventName}</td>
				<td>${eventDetails.eventDate}</td>
			</tr>
			</c:forEach>
		</table>
		<br />
		<input type = "submit" value = "Create Event">
	</form>
	<a href = "index.html">Create a Baby Instead</a>
</body>
</html>