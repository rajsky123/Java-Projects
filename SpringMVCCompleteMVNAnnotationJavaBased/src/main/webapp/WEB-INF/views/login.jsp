<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:form action="loginSuccess" modelAttribute="studentCredential"
		method="post">
		<table align="center">
			<caption align="top">Student Login Form</caption>
			
			<tr>
				<td>Enter Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>