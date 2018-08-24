<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>Home Page</title>
</head>
<body>
<h3 align="right"><a href="/SpringMVCCompleteMVNAnnotationJavaBased">Back</a></h3>
	<h2 align="center">${headerMessage}</h2>
	<h3 align="center">You have registered with following Info::::</h3>
	<table align="center" border="5px">
	
			<tr>
			<td>Student Rollno:</td>
			<td>${student.rollno}</td>
		</tr>
	
		<tr>
			<td>Student Name:</td>
			<td>${student.name}</td>
		</tr>
		
		<tr>
			<td>Student Graduation Type:</td>
			<td>${student.graduationType}</td>
		</tr>

		<tr>
			<td>Student Stream</td>
			<td>${student.stream}</td>
		</tr>

	</table>
</body>
</html>