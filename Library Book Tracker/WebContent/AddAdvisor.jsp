<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>

	
	<%
			UserDAO dataobject1= new UserDAO();

			String studentname = request.getParameter("studentname");
			String advisorname = request.getParameter("teachername");
			
			int student_id = dataobject1.getIdByUserName(studentname);
			int advisor_id = dataobject1.getIdByUserName(advisorname);


			String msg ="LINKED SUCCESSFULLY"; 

			
		
		try
			{
			
			dataobject1.insertStudentAdvisorMapping(student_id, advisor_id);
			
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


	
	

