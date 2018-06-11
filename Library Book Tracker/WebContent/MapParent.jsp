<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>

	
	<%
			UserDAO dataobject1= new UserDAO();

			String studentname = request.getParameter("studentname");
			String parentname = request.getParameter("parentname");
			
			int student_id = dataobject1.getIdByUserName(studentname);
			int parent_id = dataobject1.getIdByUserName(parentname);


			String msg ="LINKED SUCCESSFULLY"; 

			
		
		try
			{
			
			dataobject1.insertStudentParentMapping(student_id,parent_id);
			
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


	
	

