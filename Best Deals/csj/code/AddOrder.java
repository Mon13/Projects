import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;




public class AddOrder extends HttpServlet {

	
	int numb;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession();
            
		try{
			
			String userName = request.getParameter("userName");
			String orderName = request.getParameter("orderName");
			String orderPrice = request.getParameter("orderPrice");
			String creditCard = request.getParameter("creditCardNo");
			String address = request.getParameter("userAddress");

			PrintWriter out = response.getWriter(); 
		
			String msg="null";
		
	
			numb = MySqlDataStoreUtilities.selectOrderNumb();
			int orderId= numb+1;

			MySqlDataStoreUtilities.addOrder(orderId,userName,orderName,orderPrice,creditCard,address);
			msg="Your order is placed and the order ID is "+orderId;

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			msg+="Your order is placed on "+dateFormat.format(date);


		Calendar c = Calendar.getInstance();
    	c.setTime(date); 
    	c.add(Calendar.DATE, 14); 
    	msg+="Your order will be delivered on " + dateFormat.format(c.getTime());

		out.print("<HTML style='background-color:#FCEA82'>");
		out.print("<h2 align='center'>"+ msg +" </h2>");
		out.print("<center><img src='images/thankyou.jpg' style='width:40%' alt='Thank you'/><br>");
		out.print("<a href = 'Salesmen'>Back</a>");
		out.print("</HTML>");

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	}

	
	
}
