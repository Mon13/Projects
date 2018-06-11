import java.io.*;

import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteOrder extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlString = "";

try
{
String orderID = request.getParameter("OrderId");
MySqlDataStoreUtilities.deleteOrder(orderID);



		}
		catch (Exception e) {
				e.printStackTrace();
		}

		//response.sendRedirect("/csj/CheckOut");
	htmlString+="<h3>ORDER HAS BEEN DELETED</h3>";
		htmlString+="<a href = 'Salesmen'>Back</a>";

		pw.println(htmlString);

}}



