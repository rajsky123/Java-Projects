<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>Registration Page</title>
</head>
<body>

	<h3 align="center">${headerMessage}</h3>
	<form:form action="registerSuccess" modelAttribute="student"
		method="post">
		<table align="center">
			<caption align="top">Student registration form</caption>
			
			<tr>
				<td>Enter Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			
			<tr>
				<td>Select Graduation Type:</td>
				<td><form:select path="graduationType">
						<form:options items="${graduationType}" />
					</form:select></td>
			</tr>
			
			<tr>
				<td>Select Stream:</td>
				<td><form:select path="stream">
						<form:options items="${stream}" />
					</form:select></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>