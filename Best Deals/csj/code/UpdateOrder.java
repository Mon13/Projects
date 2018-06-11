import java.io.*;




import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;




public class UpdateOrder extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession();
            
		try{
			
			String orderId = request.getParameter("OrderId");
			String orderName = request.getParameter("orderName");
			String orderPrice = request.getParameter("orderPrice");
			String creditCard = request.getParameter("creditCardNo");
			String address = request.getParameter("userAddress");

			PrintWriter out = response.getWriter(); 
		
			String msg="null";
		
	

			MySqlDataStoreUtilities.updateOrder(orderId,orderName,orderPrice,creditCard,address);
			msg="The order is updated for the given order ID  "+orderId;

		out.print("<HTML style=\"background-color:#FCEA82\">");
		out.println("<h2 align='center'>" + msg + "</h2>");
		out.print("<a href = 'Salesmen'>Back</a>");
		out.print("</HTML>");

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	}

	
	
}
