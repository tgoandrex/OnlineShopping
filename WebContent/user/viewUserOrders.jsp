	<jsp:include page="/header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
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
 
		<h1>Online Shopping <small>View User Orders</small></h1>
		<hr>
		<table class="table table-striped table-hover table-responsive shopping-datatable">
			<thead>
				<tr>
					<th class="text-center">Order ID</th>
					<th class="text-center">Number of Items</th>
					<th class="text-center">Total Price</th>
					<th class="text-center">Created on</th>
					<th class="text-center">Products in this Order</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
					<tr>
						<td><c:out value="${order.orderId}" /></td>
						<td><c:out value="${order.quantity}" /></td>
						<td><fmt:formatNumber value="${order.price}" type="currency" /></td>
						<td><fmt:formatDate value="${order.orderDate}" pattern="MM/dd/yyyy hh:mm:ssa z" /></td>
						<td><c:out value="${order.getProducts()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Create User Orders</h3>
		<hr>
		<form action="createOrders" method="post" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Create an Order</button>
				</div>
			</div>
		</form>
		<h3>Delete User Orders</h3>
		<hr>
		<form action="deleteUserOrders" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="order" items="${orders}">
							<option value="${order.orderId}">${order.orderId}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
		    	<div class="col-sm-offset-4 col-sm-1">
		 	  		<button type="submit" class="btn btn-primary">Delete</button>
		 	 	</div>
			</div>
		</form>
	</div>
	</header>

	<jsp:include page="/footer.jsp" />