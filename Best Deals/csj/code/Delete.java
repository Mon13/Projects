import java.io.*;

import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Delete extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlString = "";

try
{
String prodName = request.getParameter("productname");
MySqlDataStoreUtilities.delete(prodName);



		}
		catch (Exception e) {
				e.printStackTrace();
		}

		//response.sendRedirect("/csj/CheckOut");

		htmlString+="<a href = 'CheckOut'>Back";

		pw.println(htmlString);

}}



