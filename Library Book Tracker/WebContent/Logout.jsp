	<%
			session.removeAttribute("username");
			session.invalidate();

			response.sendRedirect("Home.jsp");  
		%>