<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>Home Page</title>
</head>
<body>
<h3 align="center">${headerMessage}</h3>
<table align="center">
            <tr> 
                <security:authorize access="isAnonymous()">
                <td><a href="${pageContext.request.contextPath}/loginSuccess">Login</a>
                </td>
                <td><a href="${pageContext.request.contextPath}/register">Register</a>
                </td>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                <td><a href="${pageContext.request.contextPath}/loginSuccess">Your Profile</a>
                </td>
                </security:authorize>
                
            </tr>
        </table>

</body>
</html>