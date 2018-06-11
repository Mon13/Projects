<%@ page import="controllers.UserDAO" %>
<%@ page import="models.BookBean" %>
<%@ page import="java.io.*" %>

	
	<%
			BookBean bookdetails = new BookBean();

			String book_code = request.getParameter("book_col_code");
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			int book_count = Integer.parseInt(request.getParameter("count"));
		

				bookdetails.setSchoolGeneratedId(book_code);
				bookdetails.setIsbn(isbn);	
				bookdetails.setBookTitle(title);	
				bookdetails.setBookAuthor(author);	
				bookdetails.setNoOfCopies(book_count);


			String msg ="BOOK ADDED SUCCESSFULLY"; 

			
		
		try
			{
			
			
			UserDAO dataobject1= new UserDAO();

			
		
			
			dataobject1.insertBook(bookdetails); 
			
			
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


	
	

