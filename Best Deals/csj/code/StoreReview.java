import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.HttpSession;


public class StoreReview extends HttpServlet {
	
	
	public void init() throws ServletException{}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			
			HttpSession session = request.getSession();
			String userName = session.getAttribute("username").toString();

			
			String productName = (String)session.getAttribute("productname");
			String productCategory = (String)session.getAttribute("producttype");
			int productPrice = Integer.parseInt((String)session.getAttribute("productprice"));
			String retailerName = (String)session.getAttribute("retailers");


			String retailerZip = request.getParameter("RetailerZip");
			String retailerCity = request.getParameter("RetailerCity");
			String retailerState = request.getParameter("RetailerState");
			String productSale = request.getParameter("ProductOnSale");
			String manufactureName = request.getParameter("ManufacturerName");
			String manufactureRebate = request.getParameter("ManufacturerRebate");
			
			int userAge = Integer.parseInt(request.getParameter("UserAge"));
			String userGender = request.getParameter("UserGender");
			String userOccu = request.getParameter("UserOccupation");
			int reviewRating = Integer.parseInt(request.getParameter("ReviewRating"));	
			String reviewDate = request.getParameter("ReviewDate");
			String reviewText = request.getParameter("ReviewText");
										
			
				 MongoDbDataStoreUtilities.insertReview(productName,productCategory, productPrice,retailerName,retailerZip,retailerCity,retailerState,productSale,manufactureName,manufactureRebate,userName,userAge, userGender, userOccu, reviewRating,reviewDate,reviewText);
									
		
		
				response.sendRedirect("/csj/Home");
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}