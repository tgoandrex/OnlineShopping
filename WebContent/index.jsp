	<jsp:include page="header.jsp"/>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <header>
        <div class="container">
        
        <c:choose>
			<c:when test="${not empty message }">
	 	 		<p class="alert ${messageClass}">${message }</p>
				<%
	  			session.setAttribute("message", null);
	  			session.setAttribute("messageClass", null);
				%>
			</c:when>
		</c:choose>
	
            <div class="row">
            	<div class="col-lg-12">
                	<h1>Online Shopping <small>Shopping, Made Easy.</small></h1>
                	<hr>
                </div>
            </div>
        </div>
    </header>

    <jsp:include page="footer.jsp"/>