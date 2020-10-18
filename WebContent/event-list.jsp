<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event List</title>
</head>
<body>
	<form method = "post" action = "eventNavigationServlet">
		<table>
			<c:forEach items = "${requestScope.allDetails}" var = "eventDetails">
			<tr>
				<td><input type = "radio" name = "id" value = "${eventDetails.eventId}"></td>
				<td>${eventDetails.eventName}</td>
				<td>${eventDetails.eventDate}</td>
				<td>${eventDetails.baby}</td>
			</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "delete" name = "doThisToEvent">
		<input type = "submit" value = "add" name = "doThisToEvent">
	</form>
</body>
</html>