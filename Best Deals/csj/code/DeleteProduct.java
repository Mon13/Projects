import java.io.*;

import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteProduct extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlString = "";

try
{
String prodName = request.getParameter("productname");
MySqlDataStoreUtilities.deleteProduct(prodName);



		}
		catch (Exception e) {
				e.printStackTrace();
		}

		//response.sendRedirect("/csj/CheckOut");
	htmlString+="<h3>PRODUCT HAS BEEN DELETED</h3>";
		htmlString+="<a href = 'Storemanager'>Back</a>";

		pw.println(htmlString);

}}



