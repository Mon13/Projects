<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>

	
	<%
			UserDAO dataobject1= new UserDAO();

			String coursename = request.getParameter("coursename");

			String msg ="DELETED SUCCESSFULLY"; 

			
		
		try
			{
			
			dataobject1.deletecourse(coursename);
			
			}
			catch(Exception e)
			{}
	%>
		

		<HTML style="background-color:#FCEA82">
		<header>
	
    	</header>
		<h2 align='center'> <%= msg %> </h2>
		<a href = 'Admin.jsp'><center>BACK</center></a>
		</HTML>


	
	

