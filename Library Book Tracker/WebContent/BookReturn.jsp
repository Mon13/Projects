
<%@ page import="controllers.UserDAO" %>
<%@ page import="models.BookCheckoutBean" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
	
	<%
			UserDAO dataobject1= new UserDAO();

			String studentname = request.getParameter("studentname");
			//int student_id = dataobject1.getIdByUserName(studentname);

			String bookname = request.getParameter("bookname");
			//int book_id = dataobject1.getBookIdByName(bookname);

			//BookCheckoutBean bookObject = new BookCheckoutBean();
			//bookObject.setId(book_id);*/

			SimpleDateFormat todayDate = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c1 = Calendar.getInstance();
			Date date = new Date();
			date = c1.getTime();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			


			String msg ="BOOK RETURNED SUCCESSFULLY"; 

			
		
		try
			{
			
			dataobject1.bookReturn(studentname,bookname,sqlDate);
			
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


	
	

