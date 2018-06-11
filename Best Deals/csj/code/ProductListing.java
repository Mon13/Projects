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

public class ProductListing extends HttpServlet {
	Utili u = new Utili();
	Connection conn;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String htmlString = "";
	PrintWriter out = response.getWriter();
	String Productid=request.getParameter("id");

HttpSession session= request.getSession();
	try
{

	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

response.setContentType("text/html");


 

			htmlString = u.printHtml("Header.html");
if (session.getAttribute("username")!=null){
String username = session.getAttribute("username").toString();
username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlString = htmlString
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";
}
			

			  PreparedStatement psmt = conn.prepareStatement("select * from Products where productid = ?");
	    		psmt.setString(1,Productid);
	    	  ResultSet rs = psmt.executeQuery();

	    	  while(rs.next())
				
			{
				
			htmlString += "<li><div><ul type='none'><li><center>"+rs.getString(5)+"</center></li><li><center><img width='200px' height='200px' src='images/"+rs.getString(4)+"' /></center></li><li><center>Retailer:"+rs.getString(2)+"</li></center><li><center>Condition:"+rs.getString(6)+"</li></center><li><center>price:$"+rs.getInt(7)+"</li></center><li><center><li></li><br><li></li><br><li></li><br></ul></li>";
				
			htmlString +="<form method='post' action='/csj/Cart'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"' /><li><center><input type='submit' value='Add to cart' size='06'/></center></li></form>";				
			htmlString +=  "<form method='post' action='/csj/WriteReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><input type='hidden' name='productprice' value='"+rs.getInt(7)+"'/><input type='hidden' name='retailers' value='"+rs.getString(2)+"'/><input type='hidden' name='producttype' value='"+rs.getString(3)+"'/><li><center><input type='submit' value='Write Review' size='06'/></center></li></form>";
			htmlString +=  "<form method='get' action='/csj/ViewReview'><input type='hidden' name='productname' value='"+rs.getString(5)+"'/><li><center><input type='submit' value='View Review' size='06'/></center></li></form>";

			}

		}
		catch (Exception e) {
				e.printStackTrace();
		}

			htmlString +="</ul></div>";

htmlString += u.printHtml("Nav.html");
htmlString += u.printHtml("LeftNav.html");
htmlString += u.printHtml("Footer.html");

out.println(htmlString);
}}