	<%@ page isErrorPage="true" %>
	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<header>
	  <div class="container">
	
		<%
			out.println("<p class=\"alert alert-danger\">Something went wrong</p>");
		%>
		
		<h1>Online Shopping <small>Error</small></h1>
		<hr>
		<p>Your code threw an exception</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>

	  </div>
	</header>

	<jsp:include page="footer.jsp" />
