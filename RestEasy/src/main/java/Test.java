

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@WebServlet("/test")
public class Test extends GenericServlet {
	private static final long serialVersionUID = 1L;
       

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		User user=new User();
		user.setName("jaggu");
		user.setJob("comp");
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			 ResteasyWebTarget target = client.target("https://reqres.in/api/users?page=2");
			 
			 Response presponse = target.request().get();
//					 .post(
//	                    Entity.entity(user, "application/json"));
	 
	            
	            
	            System.out.println("Server response : \n");
	            request.setAttribute("re", presponse.readEntity(String.class));
	            presponse.close();
			 
			 
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/hello.jsp");
		requestDispatcher.forward(request, response);
	}

}
