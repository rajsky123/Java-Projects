<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! Object flag=0; %>

	<form action="login" method="Post">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name=nm></td>
			</tr>
			<tr>	
				<td>Place:</td>
				<td><input type="text" name=pl></td>
			</tr>
			<tr>
			    <td></td><td><input type="submit" value="Submit"></td>
			</tr>     
			    
		</table>
	</form>
	<p id="myP" style="color:red;text-align:center">Invalid Username Password</p>
	
	<% flag=request.getAttribute("flag");%>
<script>
    var flag=<%=flag%>;
     if(flag!=1)
    	 document.getElementById("myP").style.visibility = "hidden";
</script>       
	
</body>
</html>