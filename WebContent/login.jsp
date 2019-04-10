	<jsp:include page="header.jsp" />
	
	<header>
	  <div class="container">	
		<h1>Online Shopping <small>Login</small></h1>
		<hr>
		<form action="j_security_check" method="post" class="form-horizontal">
		  <div class="form-group">
		    <label for="j_username" class="col-sm-4 control-label">Username</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" name="j_username" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="j_password" class="col-sm-4 control-label">Password</label>
		    <div class="col-sm-4">
		      <input type="password" class="form-control" name="j_password" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <input type="submit" class="btn btn-primary" value="Login">
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<jsp:include page="footer.jsp" />