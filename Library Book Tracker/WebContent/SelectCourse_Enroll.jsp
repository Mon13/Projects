<%@ page import="controllers.UserDAO" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>



<%
	

String msg;
	
	try{
			
			
			String userName = session.getAttribute("username").toString();
			String courseName = request.getParameter("coursename");
			
			UserDAO obj1=new UserDAO();

		int result=	obj1.insertStudentCourseMapping(userName,courseName);
			if (result == 1){
				 msg = "Course Registration limit reached";
			}
			else{
				msg = "Course Registration Successful";
			}

%>

		<HTML style="background-color:#FCEA82">

		<br>
		<h2 align = 'center'> <%=msg %></h2>
		<a href = 'Student.jsp'>BACK</a>
		</center>
		</HTML>

		<%
		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	
		%>
	
	

