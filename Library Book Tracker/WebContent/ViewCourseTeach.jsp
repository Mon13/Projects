<%@ page import="controllers.UserDAO" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<!doctype html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HIGH SCHOOL LIBRARY</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>


<body>
<div id="container">
  <header>
    	<h1><a href="home.jsp">WISDOM HIGH SCHOOL LIBRARY</a></h1>
        <h2></h2>
    <img src="images/LIBB.jpg" style="width:75%" style="height:10%" alt="BOOKS" />

    </header>

    <%
    
    if (session.getAttribute("username")!=null)
    {
    String username = session.getAttribute("username").toString();
    username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
    %>


    <li><a>Hello, <%= username %> </a></li>
    <li><a href='Logout.jsp'>Logout</a></li>

<% } else { %>
     <li><a>Hello </a></li>

   <% } %>


    <div id="body">

        <section id="content">

        <article>
        
        <h3>LIST OF COURSES TAUGHT</h3>
        
        <%  
        	UserDAO databaseObj = new UserDAO();
            String username = session.getAttribute("username").toString();
     
           	List<String> result = databaseObj.getCourseNames(username);
        	String htmlpage="\n";
            
           	for(int i=0;i<result.size();i++)
            {
           		htmlpage+= "<h4>";
            	 htmlpage+=result.get(i); 
           		 htmlpage+= "</h4><br>";
           		
           	} 
           	out.print(htmlpage);
       		

    
    %>
    


        </article>
        </section>




        </section>
        

    	<div class="clear"></div>
    </div>

   <footer>

            
            <div class="footer-bottom">
                <p>WISDOM HIGH SCHOOL LIBRARY - COPYRIGHT (C) 2017</p>
            </div>

        </footer>
</div>
</body>
</html>
