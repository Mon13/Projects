<%@ page import="controllers.UserDAO" %>
<%@ page import="models.CourseBean" %>
<%@ page import="java.io.*" %>

	
	<%
			CourseBean coursedetails = new CourseBean();

			String courseName = request.getParameter("coursename");
			String courseCode = request.getParameter("coursecode");
			
			

			coursedetails.setName(courseName);
			coursedetails.setCode(courseCode);


			String msg ="COURSE ADDED SUCCESSFULLY"; 

			
		
		try
			{
			
			
			UserDAO dataobject1= new UserDAO();

			
		
			
			dataobject1.insertCourse(coursedetails); 
			
			
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


	
	

