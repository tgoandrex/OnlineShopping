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
 
		<h1>Online Shopping <small>View Products</small></h1>
		<hr>
		<table class="table table-striped table-hover table-responsive shopping-datatable">
			<thead>
				<tr>
					<th class="text-center">Product ID</th>
					<th class="text-center">Name</th>
					<th class="text-center">Price</th>
					<th class="text-center">Created/Updated on</th>
					<th class="text-center">Assigned to Category</th>
					<th class="text-center">Inventory</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td><c:out value="${product.productId}" /></td>
						<td><c:out value="${product.name}" /></td>
						<td><fmt:formatNumber value="${product.price}" type="currency" /></td>
						<td><fmt:formatDate value="${product.createDate}" pattern="MM/dd/yyyy hh:mm:ssa z" /></td>
						<td><c:out value="${product.getCategory()}" /></td>
						<td><c:out value="${product.inventory}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Add to Orders</h3>
		<hr>
		<form action="addToOrders" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="productId" class="col-sm-4 control-label">Product ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="productId">
						<c:forEach var="product" items="${products}">
							<option value="${product.productId}">${product.productId}: ${product.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="orderId" class="col-sm-4 control-label">Add to Order ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="orderId">
						<c:forEach var="order" items="${orders}">
							<option value="${order.orderId}">${order.orderId}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Add to Order</button>
				</div>
			</div>
		</form>
	</div>
	</header>

	<jsp:include page="/footer.jsp" />