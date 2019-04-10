	<%@ page isErrorPage="true" %>
	<jsp:include page="header.jsp" />

	<header>
	  <div class="container">
	
		<%
			out.println("<p class=\"alert alert-danger\">Something went wrong</p>");
		%>
		
		<h1>Online Shopping <small>404 Page Not Found</small></h1>
		<hr>
		<p>
		  Cannot find requested resource
		</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>

	  </div>
	</header>

	<jsp:include page="footer.jsp" />