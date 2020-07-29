<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User list</title>
</head>
<body>
	<table cellspacing="0" cellpadding="5" border="1" align="center">
		<tr>
			<th>Email</th>
			<th>Name</th>
			<th>Password</th>
			<th>Introduction</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="user" items="${ users}">
			<tr>
				<td>${user.email }</td>
				<td>${user.name }</td>
				<td>${user.pass }</td>
				<td>${user.intro }</td>
				<td><a href="user-management/edit?email=${user.email }">Edit</a></td>
				<td><a href="user-management/delete?email=${user.email }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr><td colspan="6">Total: ${users.size() } Users</td></tr>
	</table>
	<a href="user-management/new">Add new user</a>
</body>
</html>