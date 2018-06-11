import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Registration extends HttpServlet {

	
	
	int numb;
	
	public void init() throws ServletException{
     
		MySqlDataStoreUtilities.getConnection();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter(); 
		
			String msg="null";
		
		try
			{
			numb = MySqlDataStoreUtilities.selectUser(userName);
			
			

			if(numb == 1)
			msg = "Username already exist. Please select a different username"; 
		
			else if(numb == 0)
			{
			String userType="customer";
			MySqlDataStoreUtilities.insertUser(userName,password,userType); 
			msg ="You have been added.Please Login Again"; 
			}
}
catch(Exception e)
			{}

		out.print("<HTML style=\"background-color:#FCEA82\">");
		out.println("<h2 align='center'>" + msg + "</h2>");
		out.print("<a href = 'SignIn'>Back");
		out.print("</HTML>");

		} 
		
	}

	
	

