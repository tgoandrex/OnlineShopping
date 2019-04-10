	<jsp:include page="/header.jsp"/>
	
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
		<h1>Online Shopping <small>Edit Products</small></h1>
		<hr>
		<h3>Create Products</h3>
		<hr>
		<form action="createProducts" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="name" placeholder="Name your product" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-4 control-label">Price</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name="price" placeholder="Set your price" min="0.00" step="0.01" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inventory" class="col-sm-4 control-label">Inventory</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name="inventory" placeholder="Number in Stock" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>
			</div>
		</form>
		<h3>Update Products</h3>
		<hr>
		<form action="updateProducts" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">Id</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="product" items="${products}">
							<option value="${product.productId}">${product.productId}: ${product.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
			<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="name" placeholder="New name" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-4 control-label">Price</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name="price" placeholder="Update the price" min="0.00" step="0.01" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inventory" class="col-sm-4 control-label">Inventory</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name="inventory" placeholder="Number in Stock" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Update</button>
		    	</div>
		    </div>
		</form>
		<h3>Delete Products</h3>
		<hr>
		<form action="deleteProducts" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="product" items="${products}">
							<option value="${product.productId}">${product.productId}: ${product.name}</option>
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

    <jsp:include page="/footer.jsp"/>