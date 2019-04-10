	<jsp:include page="header.jsp" />
	
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
	
		<h1>Online Shopping <small>Register</small></h1>
		<hr>
		<form action="registration" method="post" class="form-horizontal">
		  <div class="form-group">
		    <label for="username" class="col-sm-4 control-label">Username</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" name="username" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-4 control-label">Password</label>
		    <div class="col-sm-4">
		      <input type="password" class="form-control" name="password" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <input type="submit" class="btn btn-primary" value="Register">
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<jsp:include page="footer.jsp" />