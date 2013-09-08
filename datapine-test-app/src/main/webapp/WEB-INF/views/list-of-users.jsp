<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Users</title>
</head>
<body>
<h1>List of Users</h1>
<p>Here you can see the list of the users, edit or remove them.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">id</th><th width="15%">email</th><th width="10%">password</th><th width="10%">actions</th>
</tr>
</thead>
<tbody>
<h2>${message}</h2>
<c:forEach var="user" items="${users}">
<tr>
	<td>${user.id}</td>
	<td>${user.email}</td>
	<td>${user.password}</td>
	<td>
	<a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
${userID}
<p><a href="${pageContext.request.contextPath}/user/home/${userID}">User home page</a></p>

</body>
</html>