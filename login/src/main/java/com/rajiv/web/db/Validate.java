package com.rajiv.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Validate {

	public boolean check(String name,String password)throws Exception
	{   String qry="select * from user where username=? and password=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
		PreparedStatement st=con.prepareStatement(qry);	
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return true;
		return false;
	}

	
}
