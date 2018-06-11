import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class CheckOut extends HttpServlet {
	Utili u = new Utili();
	Connection conn;
	 int sum;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlString = "";
HttpSession session= request.getSession();
String username = session.getAttribute("username").toString();
try
{
htmlString = u.printHtml("Header.html");

if (session.getAttribute("username")!=null)
{

username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlString = htmlString
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";
}



	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");


 PreparedStatement psmt = conn.prepareStatement("select * from Cart where username = ?");
	    		psmt.setString(1,username);
	    	  ResultSet rs = psmt.executeQuery();
	    	 

	    	  htmlString +="<center><table style='width:40%''><tr><th>Product Name</th><th>Product Price</th></tr>";

	    	  while(rs.next())
				
			{
				htmlString +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td><form method='get' action='/csj/Delete'><input type='hidden' name='productname' value='"+rs.getString(1)+"'/><input type='submit' value='Delete'/></form></td></tr>";
				

			}
			sum= MySqlDataStoreUtilities.sum(username); 

htmlString +="<tr><th>Total</th><th>"+sum+"</th></table>";	

htmlString += "<form action='Order' method='post'>"+
  			"<label class='label'>Credit Card </label>"+ 
            "<input type='text' class='field' name='creditcard'>"+
            "<label class='label'>Address </label>"+ 
            "<input type='text' class='field' name='address'>"+
    "<button class='Order'>Checkout</button></form></center>";

    

		}
		catch (Exception e) {
				e.printStackTrace();
		}

			htmlString +="</ul></div>";

htmlString += u.printHtml("Nav.html");
htmlString += u.printHtml("LeftNav.html");
htmlString += u.printHtml("Footer.html");

pw.println(htmlString);
}}

