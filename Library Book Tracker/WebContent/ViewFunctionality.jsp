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

            <a href="ViewUser.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:210px;height:100px" value="SUBMIT"> VIEW USERS </button></a> 
           <br>
            <br> 
       
            <a href="ViewAllBooks.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:210px;height:100px" value="SUBMIT"> VIEW ALL BOOKS </button></a> 
           <br>
            <br> 

             <a href="ViewBorrowedBook_Students.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:210px;height:100px" value="SUBMIT"> LIST OF STUDENTS AND BOOK BORROWED</button></a> 
           <br>
            <br> 

             <a href="ViewBorrowedBooks_Name.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:210px;height:100px" value="SUBMIT"> LIST OF BOOKS BORROWED </button></a> 
           <br>
            <br> 



        </section>
        <aside class="sidebar">
    
            <ul>

              <li></li>

    <td>
    <ul>
        

           
      
        </ul>
        </td>
                    
        </aside>
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
