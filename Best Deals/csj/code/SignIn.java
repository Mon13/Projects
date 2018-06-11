


import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SignIn extends HttpServlet {
	Utili u = new Utili();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String htmlPage = "";
HttpSession session= request.getSession();


htmlPage = u.printHtml("Header.html");


htmlPage = htmlPage
+ "</ul></div></span></div></td>";
htmlPage += "<center><img width='30%' height='10%' src='images/ElectronicsShopping.jpg'/></center>";  
htmlPage += u.printHtml("UpperNav.html");
htmlPage += "<center><h2>LOGIN AND REGISTRATION</h2></center>";
htmlPage += u.printHtml("Login.html");
htmlPage += u.printHtml("LeftNav.html");
htmlPage += u.printHtml("Footer.html");


pw.println(htmlPage);
}
}

	


