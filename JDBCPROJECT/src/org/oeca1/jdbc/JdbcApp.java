package org.oeca1.jdbc;

import java.sql.*;


public class JdbcApp {

	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
		String qry="select name,hiredate from testdb.emp where location=? or location=?";
		PreparedStatement st=con.prepareStatement(qry);
		st.setString(1,"bangalore");
		st.setString(2,"bhubaneswar");
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{  
			Date d=rs.getDate(2);
			String s=rs.getString(1);
			System.out.println(s+" "+d);
			
		}
				con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
