


import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class WriteReview extends HttpServlet {
	Utili u = new Utili();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlPage = "";
HttpSession session= request.getSession();
String username = session.getAttribute("username").toString();


htmlPage = u.printHtml("Header.html");

if (session.getAttribute("username")!=null){
username = session.getAttribute("username").toString();
username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
htmlPage = htmlPage
+ "<li><a>Hello, "+username+"</a></li>"
+ "<li><a href='Logout'>Logout</a></li>";
}

htmlPage = htmlPage
+ "</ul></div></span></div></td>";
htmlPage += u.printHtml("Nav.html");
htmlPage = htmlPage
+ "</ul></div></span></div></td>";

String prodName = request.getParameter("productname");
 session.setAttribute("productname",prodName); 
String prodPrice = request.getParameter("productprice");
 session.setAttribute("productprice",prodPrice); 
String retailerName = request.getParameter("retailers");
 session.setAttribute("retailers",retailerName); 
String prodCategory = request.getParameter("producttype");
 session.setAttribute("producttype",prodCategory); 

					htmlPage+="<table><tr>";
					htmlPage+="<td> Product Name: </td>";
					htmlPage+="<td>" +prodName+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product Category: </td>";
					htmlPage+="<td>" +prodCategory+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Product Price: </td>";
					htmlPage+="<td>" +prodPrice+ "</td>";
					htmlPage+="</tr>";

					htmlPage+="<tr>";
					htmlPage+="<td> UserId: </td>";
					htmlPage+="<td>" +username+ "</td>";
					htmlPage+="</tr>";
					
					htmlPage+="<tr>";
					htmlPage+="<td> Retailer Name: </td>";
					htmlPage+="<td>" +retailerName+ "</td>";
					htmlPage+="</tr></table>";

			

htmlPage += u.printHtml("Review.html");


htmlPage += u.printHtml("Footer.html");


pw.println(htmlPage);
}
}

	


