import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;



public class Cart extends HttpServlet {

	
	Connection conn;
	Utili u = new Utili();

	public void init() throws ServletException{
     
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String htmlString = "";
		PrintWriter out = response.getWriter();

		try{

			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");
			response.setContentType("text/html");

			String prodName = request.getParameter("productname");
			int prodPrice = Integer.parseInt(request.getParameter("productprice"));

			HttpSession session= request.getSession();
            String username = session.getAttribute("username").toString();

			
		
		
			htmlString = u.printHtml("Header.html");
if (session.getAttribute("username")!=null){
//String username = session.getAttribute("username").toString();
//username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlString = htmlString
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";
}
		
		
			
			MySqlDataStoreUtilities.insertProduct(prodName,prodPrice,username); 

			 PreparedStatement psmt = conn.prepareStatement("select * from Cart where username = ?");
	    		psmt.setString(1,username);
	    	  ResultSet rs = psmt.executeQuery();

	    	  htmlString +="<center><table style='width:40%''><tr><th>Product Name</th><th>Product Price</th></tr>";

	    	  while(rs.next())
				
			{
				htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>";
			}

htmlString +="</table>";			

 //htmlString +="<form method='post' action='/csj/Order'><input type='hidden' name='productname' value='"+rs.getString(1)+"'/><input type='submit' value='Check Out' size='06'/></form>";
htmlString += "<a href = 'CheckOut'>Check Out";
htmlString +="</center>";

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}

//htmlString +="</ul></div>";

htmlString += "<left>"+u.printHtml("Nav.html")+"</left>";
//htmlString += u.printHtml("LeftNav.html");
//htmlString += u.printHtml("Footer.html");

out.println(htmlString);
	}
}
