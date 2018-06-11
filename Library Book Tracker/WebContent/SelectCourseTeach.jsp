<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>



<%
	

  
	
	try{
		
			
			String userName = session.getAttribute("username").toString();
			String courseName = request.getParameter("coursename");
		
			UserDAO obj1=new UserDAO();

			obj1.insertTeacherCourseMapping(userName,courseName);
			

%>

		<HTML style="background-color:#FCEA82">
		<h2 align='center'> The course to teach has been selected </h2>
		<center>
	
		<br>
		<a href = 'Teacher.jsp'>BACK</a>
		</center>
		</HTML>

		<%
		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	
		%>
	
	

