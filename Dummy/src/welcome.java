

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class welcome
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("nm");
		String place=request.getParameter("pl");
		ServletContext sc=request.getServletContext();
		sc.setAttribute("username", name);
		sc.setAttribute("location", place);
		response.sendRedirect("wel.jsp");
		
	}

}
