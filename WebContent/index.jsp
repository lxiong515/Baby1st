<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Baby First</title>
</head>
<body>
<h1>Track your baby's milestones here!</h1>
<form action="addEventServlet" method="post">
Enter the name of your baby:
<input type="text" name="babyName">
Enter the milestone:
<input type="text" name="milestone">
<input type="submit" value="Add Milestone" >
</form><br />
<a href ="viewAllItemsServlet">View all the milestones!</a>
</body>
</html>
