<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/screen.css'/>" rel="stylesheet" type="text/css" media="screen">
<title>Datapine Test Application</title>
</head>
<body>
	<div class="fieldWrapper">
	<h5>Welcome home !</h5>
	 <div class="fieldArea">
	 	  <h4>Name :</h4>
	      <p class="textColor"> ${userMessage.userName}</p>
	  </div>
	  <div class="fieldArea">
	    	<h4>Email :</h4>
	      <p class="textColor"> ${userMessage.email}</p>
	  </div>
	  <div class="fieldArea">
	    <h4>Gender :</h4>
	      <p class="textColor"> ${userMessage.gender}</p>
	  </div>
	
	<div class="homeActions"> 
		<span class="actionButtons"><a href="${pageContext.request.contextPath}/user/list"> Show list of Users</a></span>
		<span class="logout"><a href="${pageContext.request.contextPath}/logout">Log Out</a></span>
	</div>
	</div>

</body>
</html>