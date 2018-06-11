import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ViewReview extends HttpServlet {
	
	public void init() throws ServletException{}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			HttpSession session = request.getSession();
			
			
			String pName = request.getParameter("productname");
			
			String page = MongoDbDataStoreUtilities.viewReview(pName);
			
			page+="<a href = 'Home'>Back";
			
			PrintWriter out = response.getWriter();
			out.println(page);


		
			
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	
	
}