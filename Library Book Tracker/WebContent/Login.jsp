<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>

<%
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	UserDAO databseObj = new UserDAO();

int user_id= databseObj.checkCredentials(userName,password);
out.print(user_id);
		
		if(user_id == 4)
		{
			 //HttpSession session = request.getSession();  
			 session.setAttribute("username",userName); 
			 response.sendRedirect("Admin.jsp");
			


		}
		else if (user_id == 1)

		
		{
			
			 session.setAttribute("username",userName); 
			 response.sendRedirect("Student.jsp");

		}
		
		else if (user_id == 2)
		{
			 
			session.setAttribute("username",userName); 
			response.sendRedirect("Teacher.jsp");
			

		}
				
		else
		{

		%>

				<html>
				<head>
				</head>
				<body>
				<hr>
				<h2 align='center'><%=user_id %></h2>
				<div style='text-align:center'><a href='home.jsp'>HOME</a></div>
				<body>
				</html>



		<% }	%>
				
					
		
	


