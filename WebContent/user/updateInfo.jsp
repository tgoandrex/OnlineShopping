	<jsp:include page="/header.jsp" />
	
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
 
		<h1>Online Shopping <small>View User Info</small></h1>
		<hr>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<h3 class="text-center"><c:out value="${user.username}" /></h3>
				<h5 class="text-center">Current Email: <c:out value="${user.email}" /><c:if test = "${empty user.email}">None</c:if></h5>
				<h5 class="text-center">Current Address: <c:out value="${user.address}" /><c:if test = "${empty user.address}">None</c:if></h5>
				<h5 class="text-center">Current Phone Number: <c:out value="${user.phone}" /><c:if test = "${empty user.phone}">None</c:if></h5>
			</div>
		</div>
		<h3>Update Email</h3>
		<hr>
		<form action="updateEmail" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="email" class="col-sm-4 control-label">New Email</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" name="email"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Update Email</button>
		    	</div>
		    </div>
		</form>
		<h3>Update Address</h3>
		<hr>
		<form action="updateAddress" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="address" class="col-sm-4 control-label">New Address</label>
				<div class="col-sm-4">
					<input type=text class="form-control" name="address"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Update Address</button>
		    	</div>
		    </div>
		</form>
		<h3>Update Phone</h3>
		<hr>
		<form action="updatePhone" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="phone" class="col-sm-4 control-label">New Phone</label>
				<div class="col-sm-4">
					<input type="tel" class="form-control" name="phone"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Update Phone</button>
		    	</div>
		    </div>
		</form>
		<h3>Update Password</h3>
		<hr>
		<form action="changePassword" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">New Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Change</button>
		    	</div>
		    </div>
		</form>
	  </div>
	</header>

	<jsp:include page="/footer.jsp" />