import java.io.*;




import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;




public class UpdateProduct extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession();
            
		try{
			
			String productid = request.getParameter("productid");
		
			String productname = request.getParameter("productname");
			String productcondition = request.getParameter("productcondition");
			String productprice = request.getParameter("productprice");
			

			PrintWriter out = response.getWriter(); 
		
			String msg="null";
		
	

			MySqlDataStoreUtilities.updateProducts(productid,productname,productcondition,productprice);
			msg="The product is updated ";

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
