
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Login extends HttpServlet {
	
	
	String pwd;
	boolean z=false;
	String msg = "null";
	String userType;
	Connection conn;
		public void init() throws ServletException{
MySqlDataStoreUtilities.getConnection();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
				PrintWriter out = response.getWriter(); 
		try{
      	
		
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string"); 
PreparedStatement psmt = conn.prepareStatement("select * from Registration");
	    
	    	  ResultSet rs = psmt.executeQuery();
	    
	          while(rs.next())
			{
			
			  if((rs.getString(1)).equals(userName))
			  {
	
	          pwd = rs.getString(2);
	          userType = rs.getString(3);
			}	    
		}
	
			if(password.equals(pwd))
			{
				z=true;
				
			}   
			
			else{
				msg = "Login Failure! Username or password is incorrect.";
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<hr>");
				out.println("<h2 align='center'>" + msg + "</h2>");
				out.println("<div style='text-align:center'><a href='Home'>Home</a></div>");
				out.println("</body>");
				out.println("</html>");
			}
	
	if(z){
		
		if(userType.equals("customer"))
		{
			 HttpSession session = request.getSession();  
			 session.setAttribute("username",userName); 
			 response.sendRedirect("/csj/Home");
			


		}
		else if (userType.equals("storemanager"))
		{
			 HttpSession session = request.getSession();  
			 session.setAttribute("username",userName); 
			 response.sendRedirect("/csj/Storemanager");

		}
		
		else if (userType.equals("salesmen"))
		{
			 HttpSession session = request.getSession();  
			session.setAttribute("username",userName); 
			 response.sendRedirect("/csj/Salesmen");

		}
	}				
			
				
					
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	

}
