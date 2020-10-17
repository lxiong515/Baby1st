<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Babies</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items = "${requestScope.allBabies}" var = "currentbaby">
			<tr>
				<td><input type = "radio" name = "id" value = "${baby.babyId}"></td>
				<td>${baby.babyName}</td>
			</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToBaby">
		<input type = "submit" value = "delete" name = "doThisToBaby">
		<input type = "submit" value = "add" name = "doThisToBaby">
	</form>
</body>
</html>