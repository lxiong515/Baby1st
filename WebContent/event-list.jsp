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
<h1>Baby's First Milestones:</h1>
<p>Your baby's milestones are listed here. You may also add new events below!</p><br />
<h2>Add An Event</h2>
	<form action = "addEventServlet" method = "post">
		Baby ID: <input type = "text" name = "babyId">
		Event: <input type = "text" name = "event">
		<input type = "submit" value = "Add Event">
	</form><br />

	<a href = "viewAllBabiesServlet">View All Babies</a>
	<a href = "viewAllItemsServlet">View All Events</a>
	<a href = "addEventServlet">Add An Event</a>
</body>
</html>