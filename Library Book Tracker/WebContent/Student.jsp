
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
         
             <style type="text/css">
            .container {
                 width: 500px;
                 clear: both;
            }
             .container input {
                 width: 100%;
                 clear: both;
             }

            </style>

     
     <div class="container">
           
            <form action="BorrowBook.jsp" method = "get">
            <h4>BORROW BOOK </h4>
             <label class="label">BOOK NAME</label> 
            <input type="bookname" class="field" name="bookname">
        
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

             <br>
             <br>

            

          <form action="SelectCourse_Enroll.jsp" method = "get">
            <h4>TYPE  THE  COURSE  NAME  TO  ENROLL </h4>
             <label class="label">Course Name </label> 
            <input type="coursename" class="field" name="coursename">
            <br>
                <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT">
              
                <input type="hidden" name="coursename"/>
                
            </form>

       <br>
       

        </article>

        </section>
        <aside class="sidebar">
    
            <ul>

              <li></li>

    <td>
    <ul>
         <a href="ViewCourseEnrolled.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:90px" value="SUBMIT"> VIEW COURSES </button></a> 
           <br>
  			<br> <br>

   		<a href="ViewAdvisorAssigned.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:90px" value="SUBMIT"> VIEW ADVISOR </button></a> 
           <br>
  			<br> <br>

           
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
