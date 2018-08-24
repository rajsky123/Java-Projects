package beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean{
	
	private String driver,url,username,password;
	private Connection con;
	
	 public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
      public void save(int id,String name,double marks) throws SQLException
      {
    	 PreparedStatement st= con.prepareStatement("insert into student values(?,?,?)");
    	  st.setInt(1, id);
    	  st.setString(2, name);
    	  st.setDouble(3,marks);
    	  st.executeUpdate();
    	  System.out.println("record inserted successfully");
      }
	

	public void afterPropertiesSet() throws Exception {
		Class.forName(driver);
		con=DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established");
	}
public void destroy() throws Exception {

		 con.close();
		 System.out.println("connection closed");
	}

}
