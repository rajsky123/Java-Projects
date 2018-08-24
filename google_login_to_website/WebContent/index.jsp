<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="258725800887-0jo7q49gg3j9g827cvgvgrbg2071p0ke.apps.googleusercontent.com">
</head>
<style>
#logout{visibility: hidden}
.g-signin2{
padding:15px;
}
</style>
 

<body>


<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>


<img id="myImg"><br>
<p id="name"></p> 

  
<div id="status">


</div>

<button id="logout" onclick="myFunction()">Sign Out</button>

<script type="text/javascript">


			function onSignIn(googleUser) {
			// window.location.href='success.jsp';

				
			
				  var profile = googleUser.getBasicProfile();
				  var imagurl=profile.getImageUrl();
				  var name=profile.getName();
				  var email=profile.getEmail();
				     document.getElementById("myImg").src = imagurl;
				  document.getElementById("name").innerHTML = name;
				  document.getElementById("myP").style.visibility = "hidden";
				  document.getElementById("logout").style.visibility = "visible";
 
				  document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'

				   
				   
			 }

function myFunction() {
	gapi.auth2.getAuthInstance().disconnect();
    location.reload();
}
</script>
 


</body>
</html>