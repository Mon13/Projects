


import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class DealMatches extends HttpServlet {
	Utili u = new Utili();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlPage = "";
HttpSession session= request.getSession();


htmlPage = u.printHtml("Header.html");

if (session.getAttribute("username")!=null){
String username = session.getAttribute("username").toString();
username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlPage = htmlPage
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";



}

htmlPage = htmlPage+"<h1><i>We beat our competitors in all aspects. Price-Match Guaranteed</i></h1>";

String line = ""; 
      
            HashMap<String,Product> selectedproducts=new HashMap<String,Product>();
        
        try
        {

        	HashMap<String,Product> productmap=MySqlDataStoreUtilities.getProducts();


for(Map.Entry<String, Product> entry : productmap.entrySet())
{
if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
{

        	BufferedReader buff = new BufferedReader(new FileReader("/Users/mounagiri/softwares/apache-tomcat-7.0.34/webapps/csj/DealMatches.txt")); 
     

	line=buff.readLine(); 
	if(line==null)
		{
			htmlPage = htmlPage+"<h2>No Offers Found</h2>";
		}
		else 
		{
			do
			{
				if(line.contains(entry.getKey()))
				{
				
			htmlPage = htmlPage+"<h4>"+line+"</h4>";
			selectedproducts.put(entry.getKey(),entry.getValue()); 
			break;
				}
			}
			while (((line = buff.readLine()) != null));
		}
}
}
        }
catch (IOException e)
        { 
            e.printStackTrace();
        }
 
htmlPage = htmlPage+"<center><h1> ****** DEAL MATCHES  ****** </h1></center>";


if(selectedproducts.size() == 0)
{
htmlPage = htmlPage+"<h1>No Offers Found</h1>";
}
else
{
	htmlPage += MySqlDataStoreUtilities.getDealProducts(selectedproducts);
}



htmlPage += u.printHtml("Nav.html");

htmlPage += u.printHtml("LeftNav.html");



htmlPage += u.printHtml("Footer.html");


pw.println(htmlPage);


}
}

	


