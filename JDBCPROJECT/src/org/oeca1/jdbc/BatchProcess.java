package org.oeca1.jdbc;

import java.sql.*;
import java.util.Scanner;

public class BatchProcess {

	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
	
		String in1="UPDATE testdb.emp SET job=? WHERE empid=?";
		
		PreparedStatement pst=con.prepareStatement(in1);
		
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=2;i++) {
			System.out.println("enter job");
			String job=sc.next();
			pst.setString(1,job);
			System.out.println("enter id");
			int id=sc.nextInt();
			pst.setInt(2, id);
			pst.addBatch();
		}
		
		
		int ii[]=pst.executeBatch();
		for(int i:ii)
			System.out.println(i);
		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	
		
		
	}

}
