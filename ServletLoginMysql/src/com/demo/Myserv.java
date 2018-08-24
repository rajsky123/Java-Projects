package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/login" })
public class Myserv extends HttpServlet {
	
	Emp emp=new Emp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	
	String name=request.getParameter("nm");
	String place=request.getParameter("pl");
	
	request.setAttribute("name", name);
	request.setAttribute("place", place);
	
	if(check(name,place))
		{
		
		request.setAttribute("emp", emp);
		RequestDispatcher d=request.getRequestDispatcher("welcome.jsp");
		d.forward(request, response);
		}
	else
	{   request.setAttribute("flag", 1);
		RequestDispatcher d1=request.getRequestDispatcher("index.jsp");
		d1.forward(request, response);
	}
	}
	private boolean check(String name, String place) {

		Connection con=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","tiger");
			String sql="select * from testdb.emp where name=? and location=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, place);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{  
				emp.setName(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setHiredate(rs.getString(4));
				emp.setLocation(rs.getString(5));
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
