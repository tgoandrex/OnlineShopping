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
 
		<h1>Online Shopping <small>View/Delete Users</small></h1>
		<hr>
		<table class="table table-striped table-hover table-responsive shopping-datatable">
			<thead>
				<tr>
					<th class="text-center">Username</th>
					<th class="text-center">Role</th>
					<th class="text-center">Email</th>
					<th class="text-center">Address</th>
					<th class="text-center">Phone</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.username}" /></td>
						<td><c:out value="${user.getRole()}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.address}" /></td>
						<td><c:out value="${user.phone}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Delete Users</h3>
		<hr>
		<form action="deleteUsers" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-4">
					<select class="form-control" name="name">
						<c:forEach var="user" items="${users}">
							<option value="${user.username}">${user.username}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-primary">Delete User</button>
		    </div>
		</form>
	  </div>
	</header>

	<jsp:include page="/footer.jsp" />