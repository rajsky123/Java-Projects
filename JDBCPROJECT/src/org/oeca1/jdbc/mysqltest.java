package org.oeca1.jdbc;
import java.sql.*;


public class mysqltest {

	public static void main(String[] args)throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
		Statement st=con.createStatement();
		String sql="select * from emp";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)
			+" "+rs.getString(5));
			
		}
		con.close();
	}
}
