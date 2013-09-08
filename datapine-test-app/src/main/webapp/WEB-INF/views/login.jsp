<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/screen.css'/>" rel="stylesheet" type="text/css" media="screen">
<title>Datapine Login</title>
</head>
<body>
 <div class="fieldWrapper">
	<form action="${pageContext.request.contextPath}/login" method="POST">
	 	<h2>Login into Datapine Test App.</h2>
	    <div class="fieldArea">
	      <h3>Email :</h3>
	      <span><input name="email" type="text" /></span>
	    </div>
	    <div class="fieldArea">
	      <h3>password :</h3>
	      <span> <input name="password" type="password" /></span>
	    </div>
	    <div class="fieldArea">
	    	 <input type="submit" value="login" />
	    </div>
	</form>
	<span class="actionButtons"><a href="${pageContext.request.contextPath}/registered">Sign Up Free</a></span>
 </div>
</body>
</html>