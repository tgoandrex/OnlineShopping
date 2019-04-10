	<%@ page isErrorPage="true" %>
	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<header>
	  <div class="container">
	
		<%
			out.println("<p class=\"alert alert-danger\">Something went wrong</p>");
		%>
		
		<h1>Online Shopping <small>403 Forbidden</small></h1>
		<hr>
		<p>
		  The user <c:out value="${pageContext.request.userPrincipal.name}" /> does not have access to this page
		</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>

	  </div>
	</header>

	<jsp:include page="footer.jsp" />