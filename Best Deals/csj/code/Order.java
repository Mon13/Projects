import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;




public class Order extends HttpServlet {

	
	int numb;
	
	public void init() throws ServletException{
     
		MySqlDataStoreUtilities.getConnection();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
            String username = session.getAttribute("username").toString();
		try{
			
			
			String creditCard = request.getParameter("creditcard");
			String address = request.getParameter("address");

			PrintWriter out = response.getWriter(); 
		
			String msg="null";
		
	
			numb = MySqlDataStoreUtilities.selectOrderNumb();
			int orderId= numb+1;


 
		MySqlDataStoreUtilities.insertOrder(orderId,username,creditCard,address);
		msg="Your order is placed and the order ID is "+orderId;
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Date date = new Date();
msg+=".Your order is placed on "+dateFormat.format(date);


Calendar c = Calendar.getInstance();
    c.setTime(date); 
    c.add(Calendar.DATE, 14); 
    msg+=".Your order will be delivered on " + dateFormat.format(c.getTime());



		MySqlDataStoreUtilities.refresh(username);

		out.print("<HTML style=\"background-color:#FCEA82\">");
		out.println("<h2 align='center'>" + msg + "</h2>");
		out.print("<a href = 'Home'>Back");
		out.print("</HTML>");

		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
	}

	
	
}
