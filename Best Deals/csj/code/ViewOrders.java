import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;


public class ViewOrders extends HttpServlet {
	Utili u = new Utili();


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String htmlString = "";
	PrintWriter out = response.getWriter();
	
	

			htmlString = u.printHtml("Header.html");

HttpSession session= request.getSession();
			String username = session.getAttribute("username").toString();
			
		
		
		if(username.equals("salesmen"))
		{
			htmlString+=MySqlDataStoreUtilities.displayOrdersAll();
		}
		else 
		{
			htmlString+=MySqlDataStoreUtilities.displayOrders(username);

			htmlString+= "<br><form action='DeleteOrder' method='get'><label class='label'>Order ID</label><input type='OrderId' class='field' name='OrderId'><br><input type='submit' style='background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px' value='Delete Order'><input type='hidden' name='OrderId'/></form>";
		}
			

			 

			htmlString +="</ul></div>";

htmlString += u.printHtml("Nav.html");
htmlString += u.printHtml("LeftNav.html");
htmlString += u.printHtml("Footer.html");

out.println(htmlString);
}}