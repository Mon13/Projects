


import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Storemanager extends HttpServlet {
	Utili u = new Utili();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

htmlPage = htmlPage
+ "</ul></div></span></div></td>";
htmlPage += "<center><img width='40%' height='10%' src='images/ElectronicsShopping.jpg'/></center>";  
htmlPage += u.printHtml("Nav.html");
htmlPage = htmlPage
+ "</ul></div></span></div></td>";
htmlPage += u.printHtml("LeftNav.html");
htmlPage += u.printHtml("Manager.html");


htmlPage += u.printHtml("Footer.html");


pw.println(htmlPage);
}
}

	


