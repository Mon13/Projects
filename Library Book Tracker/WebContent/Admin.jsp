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
            <form action="Registration.jsp" method = "get">
            <h4>ADD NEW USER : ENTER THE DETAILS</h4>
             <label class="label">FIRST NAME </label> 
            <input type="firstname" class="field" name="firstname">
            <br>
            <label class="label">LAST NAME </label> 
            <input type="lastname" class="field" name="lastname">
            <br>
            <label class="label">GENDER </label> 
            <input type="gender" class="field" name="gender">
            <br>
            <label class="label">EMAIL </label> 
            <input type="email" class="field" name="email">
            <br>
            <label class="label">PASSWORD </label> 
            <input type="password" class="field" name="password">
            <br>
            <label class="label">PHONE NUMBER</label> 
            <input type="phonenumber" class="field" name="phonenumber">
            <br>
            <label class="label">TYPE[STUDENT,TEACHER,PARENT] </label> 
            <input type="typename" class="typname" name="typename">

            <br>
              <CENTRE> <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

            <br>
            <br>

            <h3>BOOK MANAGEMENT </h3>
            <form action="AddBook.jsp" method = "get">
            <h4>ADD NEW BOOK:</h4>
             <label class="label">BOOK_COLLEGE_CODE </label> 
            <input type="book_col_code" class="field" name="book_col_code">
            <br>
            <label class="label">ISBN </label> 
            <input type="isbn" class="field" name="isbn">
            <br>
            <label class="label">TITLE </label> 
            <input type="title" class="field" name="title">
            <br>
            <label class="label">AUTHOR </label> 
            <input type="author" class="field" name="author">
            <br>
            <label class="label">TOTAL AVAILABLE </label> 
            <input type="count" class="field" name="count">

            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

             <br>
             <br>
            <form action="DeleteBook.jsp" method = "get">
            <h4>DELETE BOOK: </h4>
            <label class="label">BOOK NAME</label> 
            <input type="bookname" class="field" name="bookname">
            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

             <br>
             <br>

            <h3>COURSE MANAGEMENT  </h3><br>
                 <form action="AddCourse.jsp" method = "get">
            <h4>ADD NEW COURSE: </h4>
             <label class="label">COURSE CODE</label> 
            <input type="coursecode" class="field" name="coursecode">
            <br>
            <label class="label">COURSE NAME</label> 
            <input type="coursename" class="field" name="coursename">
            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

             <br>
             <br>
             
            <form action="DeleteCourse.jsp" method = "get">
            <h4>DELETE COURSE: </h4>
            <label class="label">COURSE NAME</label> 
            <input type="coursename" class="field" name="coursename">
            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>

             <br>
             <br>
         

            <h3>STUDENT MANAGEMENT  </h3><br>
             <form action="AddAdvisor.jsp" method = "get">
            <h4>ADVISOR TO A STUDENT MAPPING </h4>
             <label class="label">STUDENT NAME</label> 
            <input type="studentname" class="field" name="studentname">
            <br>
            <label class="label">ADVISOR NAME</label> 
            <input type="teachername" class="field" name="teachername">
            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>
             <br>
             <br>
         

           <form action="MapParent.jsp" method = "get">
            <h4>STUDENT TO PARENT MAPPING </h4>
             <label class="label">STUDENT NAME</label> 
            <input type="studentname" class="field" name="studentname">
            <br>
            <label class="label">PARENT NAME</label> 
            <input type="parentname" class="field" name="parentname">
            <br>
               <CENTRE>  <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"></CENTRE> 
                
            </form>
             <br>
             <br>
       
       

        </article>

        </section>
        <aside class="sidebar">
    
            <ul>

              <li></li>

    <td>
     <ul>
         <a href="ViewFunctionality.jsp"><button type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT"> VIEW FUNCTIONS </button></a> 
           <br>
 <br> <br> <br>

           <form action="BookReturn.jsp" method = "get">
            <h4>BOOK RETURNED </h4>
             <label class="label">Book Name </label> 
            <input type="bookname" class="field" name="bookname">
             <label class="label">Student Name </label> 
            <input type="studentname" class="field" name="studentname">
            
            <br>
                <input type="submit" style="background-color:#DE2D3A;margin-left:45px;border-radius:5px;color:#fff;width:110px;height:40px" value="SUBMIT">    
            </form>
      
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
