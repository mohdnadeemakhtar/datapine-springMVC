<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/screen.css'/>" rel="stylesheet" type="text/css" media="screen">
<title> Registered User</title>
</head>
<body>
 <div class="fieldWrapper">
	<form:form method="POST" modelAttribute="user_registration" action="${pageContext.request.contextPath}/user/add/process">
	 	<h2>Please fill the User details.</h2>
	    <div class="fieldArea">
	      <h3>User Name :</h3>
	      <span><form:input path="userName"></form:input></span>
	    </div>
	    <div class="fieldArea">
	      <h3>Email :</h3>
	      <span><form:input path="email"></form:input></span>
	    </div>
	    <div class="fieldArea">
	      <h3>password :</h3>
	      <span><form:input path="password"></form:input></span>
	    </div>
	    <div class="fieldArea">
	      <h3>Gender :</h3>
	      <span><form:input path="gender"></form:input></span>
	    </div>
	    <div class="fieldArea">
	    	 <input  value="Add" type="submit">
	    </div>
	</form:form>
 </div>
</body>
</html>