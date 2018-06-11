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
            

        <h3>Login Using Your Credentials</h3>
            <form action="Login.jsp" method="post">
            <label class="label">Username </label> 
            <input type="text" class="field" name="username">
            <label class="label">Password </label> 
            <input type="password" class="field" name="password">
            <CENTER>
    
            <button class="Login.jsp">Login</button>
             </CENTER>
            </form>

        </form>
      
        
        </article>

	    <article>
                
            <h2>About US</h2>
            

            <p>A library is a collection of sources of information and similar resources, made accessible to a defined community for reference or borrowing.  </p>           
          
        </article>
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
