package org.oeca1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class oracletest {

	public static void main(String[] args) throws Exception{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:scott","scott","tiger");
		Statement st=con.createStatement();
		String sql="select * from emp";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)
			+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8));
			
		}
		con.close();
	}


}
