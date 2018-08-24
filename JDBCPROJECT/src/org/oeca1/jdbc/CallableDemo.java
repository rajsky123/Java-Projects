package org.oeca1.jdbc;

import java.sql.*;

public class CallableDemo{

	public static void main(String[] args) throws Exception{
         Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
		CallableStatement cst=con.prepareCall("{call testdb.empnameproc(?,?)}");
		cst.setInt(1, 5);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.execute();
		System.out.println(cst.getString(2));
	}

}
