<%@ page import="controllers.UserDAO" %>
<%@ page import="models.BookCheckoutBean" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>

	
	<%
			UserDAO dataobject1= new UserDAO();

			String studentname = session.getAttribute("username").toString();
			int student_id = dataobject1.getUserId(studentname);

			String bookname = request.getParameter("bookname");
			int book_id = dataobject1.getBookId(bookname);
			
			SimpleDateFormat todayDate = new SimpleDateFormat("dd/MM/yyyy");
			
			Calendar c2 = Calendar.getInstance();
			Calendar c1 = Calendar.getInstance();
			Date duedate = new Date();
			c1.add(Calendar.DAY_OF_MONTH,7);
			duedate = c1.getTime();
			java.sql.Date sqlDate1 = new java.sql.Date(duedate.getTime());
			
			Date checkoutdate = new Date();
			checkoutdate = c2.getTime();
			java.sql.Date sqlDate2 = new java.sql.Date(checkoutdate.getTime());
			

			BookCheckoutBean bookObject = new BookCheckoutBean();
			bookObject.setId(book_id);

			//DateFormat todayDate = new SimpleDateFormat("dd/MM/yyyy");
			//Date date = new Date();
			//date = todayDate.format(data);


			String msg ="BOOK BORROWED SUCCESSFULLY"; 

			
		
		try
			{
			
			dataobject1.insertIntoBookCheckout(student_id,book_id,sqlDate1,sqlDate2);
			
			}
			catch(Exception e)
			{}
	%>
		

		<HTML style="background-color:#FCEA82">
		<header>
	
    	</header>
		<h2 align='center'> <%= msg %> </h2>
		<a href = 'Student.jsp'><center>BACK</center></a>
		</HTML>


	
	

