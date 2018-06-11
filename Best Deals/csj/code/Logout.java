import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class Logout extends HttpServlet {
	
	
	
	public void init() throws ServletException{
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			
			PrintWriter out = response.getWriter();
			
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			session.invalidate();

			response.sendRedirect("/csj/Home");  
		}

		catch (Exception e) 
		{
		}
	}
	
	
}