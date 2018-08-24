<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Registration</title>
</head>
<style>
body
{
background: greenyellow;
}
form
{
   margin-top: 85px;
}
table
{
  border: 2px solid; 
  padding: 30px;
  margin: auto;
  background: bisque;
}
</style>
<body>
<form action="hello.jagdev" method="get">
<table>
<tr>
  <td>NAME:</td><td><input type="text" name="nm"></td>
</tr>

<tr>
  <td>PLACE:</td><td><input type="text" name="pl"></td>
</tr>
<tr>
<td></td>
<td><input type ="submit" value="Submit"></td>
</tr>
</table>
</form>

</body>
</html>