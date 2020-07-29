<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:choose>
		<c:when test="${user==null }">Add new user</c:when>
		<c:otherwise>Edit user</c:otherwise>
	</c:choose></title>
</head>
<body>
	<c:choose>
		<c:when test="${user==null }">
			<form action="add" method="post">
		</c:when>
		<c:otherwise>
			<form action="update" method="post">
		</c:otherwise>
	</c:choose>
	Email: <input type="text" <c:if test="${user!=null }">readonly</c:if> value="${user.email }" name="email"><br>
	Name: <input type="text" name="name" value="${user.name }"><br>
	Password: <input type="text" name="pass" value="${user.pass }"><br>
	Introduction: <input type="text" name="intro" value="${user.intro }"><br>
	<input type="submit" value='<c:if test="${user==null }">Add</c:if><c:if test="${user!=null }">Update</c:if>'>
	</form>
</body>
</html>