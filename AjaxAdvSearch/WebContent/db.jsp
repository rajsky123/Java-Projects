<%@ page import="java.sql.*"%>

<%
String name=request.getParameter("val");  
if(name==null||name.trim().equals("")){  
out.print("<p>Please enter name!</p>");  
}else{  
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
PreparedStatement ps=con.prepareStatement("select * from emp where name=?");
ps.setString(1, name);
ResultSet rs=ps.executeQuery();
if(!rs.isBeforeFirst()) {       
	 out.println("<p>No Record Found!</p>");   
	}else{  
	out.print("<table border='2' cellpadding='2' width='100%'>");  
	out.print("<tr><th>Id</th><th>Name</th><th>Job</th><th>Hiredate</th><th>Location</th>");  
	while(rs.next()){  
	out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"
	+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");  
	}  
	out.print("</table>");  
	}//end of else for rs.isBeforeFirst  
con.close();
}catch(Exception e){e.printStackTrace();}
}
%>