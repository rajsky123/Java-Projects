package org.oeca1.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PropertiesDemmo {

	public static void main(String[] args) throws Exception{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("config/db.properties");
		p.load(fis);
		String driver=p.getProperty("driver");
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String password=p.getProperty("password");
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement st=con.createStatement();
		String sql="select * from testdb.emp";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)
			+" "+rs.getString(5));
			
		}
		con.close(); 
	}

}
