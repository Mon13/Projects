import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;
public class AddProduct extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession();
			PrintWriter out = response.getWriter();
            
		try{
			String productid = request.getParameter("productid");

			String retailers = request.getParameter("retailers");
			String producttype = request.getParameter("producttype");
			String productimage = request.getParameter("productimage");
			String productname = request.getParameter("productname");
			String productcondition = request.getParameter("productcondition");
			String productprice = request.getParameter("productprice");
			


		
			String msg="null";
		
	
			

			MySqlDataStoreUtilities.addProduct(productid,retailers,producttype,productimage,productname,productcondition,productprice);
			msg="THE PRODUCT IS ADDED";

		out.print("<HTML style=\"background-color:#FCEA82\">");
		out.println("<h2 align='center'>" + msg + "</h2>");
		out.print("<a href = 'Storemanager'>Back</a>");
		out.print("</HTML>");

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	}

	
	
}
