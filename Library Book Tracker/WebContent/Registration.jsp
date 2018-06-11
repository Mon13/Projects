<%@page import="models.UserBean.UserType"%>
<%@ page import="controllers.UserDAO" %>
<%@ page import="models.UserBean" %>
<%@ page import="java.io.*" %>

	
	<%
			UserBean userdetails = new UserBean();

			String fName = request.getParameter("firstname");
			String lName = request.getParameter("lastname");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumb = request.getParameter("phonenumber");
			String userType = request.getParameter("typename");
			

			userdetails.setType(UserType.valueOf(userType));
			userdetails.setFirstName(fName);
			userdetails.setLastName(lName);
			userdetails.setGender(gender);
			userdetails.setPhone(phoneNumb);
			userdetails.setPassword(password);
			userdetails.setMail(email);
			
			


		String	msg ="USER ADDED SUCCESSFULLY";
		
		try
			{
			
			
			UserDAO dataobject1= new UserDAO();

			
		
			
			dataobject1.insertUserToDB(userdetails);
		 
			
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


	
	

