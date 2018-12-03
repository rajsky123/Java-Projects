<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>Login Page</title>
</head>
<style>
.error{color: red;}
</style>
<body>

	<h3 align="center">${headerMessage}</h3>
	<h3 align="center"><c:if test="${not empty msg}">
	  <span style="color:red">${msg}</span>
	</c:if></h3>
	<h3 align="center"><c:if test="${not empty errorMsg}">
	  <span style="color:red">${errorMsg}</span>
	</c:if></h3>
	<form action="${pageContext.request.contextPath}/login" 
		method="post">
		
		<table align="center">
		
			<caption align="top">Student Login Form</caption>
			
			<tr>
				<td>Enter Name:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>