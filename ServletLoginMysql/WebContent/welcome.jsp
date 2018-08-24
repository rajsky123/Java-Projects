<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>Welcome page</title>
</head>   
<body>
 <table border="1" align="center">
  <tr>
     <td>Name:</td><td>${emp.name}</td>
   </tr>
   <tr>
     <td>Job:</td><td>${emp.job}</td>
   </tr>
   
   <tr>
     <td>Hire Date:</td><td>${emp.hiredate}</td>
   </tr>  
 
   <tr>
     <td>Location:</td><td>${emp.location}</td>
   </tr>
 </table> 
</body>
</html>