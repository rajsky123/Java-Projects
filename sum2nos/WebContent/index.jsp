<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add 2 Nos</title>
</head>
<body bgcolor="coral">
<form action="index.jsp" method="post">
<table>
<tr>
<td>First No:</td><td><input type="text" name="p1" required/></td>
</tr>
<tr>
<td>Second No:</td><td><input type="text" name="p2" required/></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="submit"></td>
</tr>
<tr>
<td><input type="text" readonly value=<% if(request.getParameter("submit")==null)
	out.println();
	else
	out.println(Integer.parseInt(request.getParameter("p1"))+Integer.parseInt(request.getParameter("p2")));%>>
	</td>
	</tr>
</table>
</form>
</body>
</html>