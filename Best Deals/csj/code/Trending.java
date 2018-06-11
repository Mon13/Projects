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

public class Trending extends HttpServlet {
	Utili u = new Utili();
	Connection conn;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String htmlString = "";
	PrintWriter out = response.getWriter();
	try
{

	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","auth_string");

response.setContentType("text/html");

String ProductType=request.getParameter("type");

HttpSession session= request.getSession();
 

			htmlString = u.printHtml("Header.html");
if (session.getAttribute("username")!=null){
String username = session.getAttribute("username").toString();
username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlString = htmlString
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";
}
}
	catch (Exception e) {
				e.printStackTrace();
		}		

			  htmlString+= MongoDbDataStoreUtilities.maxRating();

			htmlString +="</ul></div>";

htmlString += u.printHtml("Nav.html");
htmlString += u.printHtml("LeftNav.html");
htmlString += u.printHtml("Footer.html");

out.println(htmlString);
}}