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
		<h1>Online Shopping <small>Edit Categories</small></h1>
		<hr>
		<h3>Create Categories</h3>
		<hr>
		<form action="createCategories" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="name" placeholder="Name your category" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>
			</div>
		</form>
		<h3>Update Categories</h3>
		<hr>
		<form action="updateCategories" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">Id</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="category" items="${categories}">
							<option value="${category.categoryId}">${category.categoryId}: ${category.name}</option>
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
				<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Update</button>
		    	</div>
		    </div>
		</form>
		<h3>Delete Categories</h3>
		<hr>
		<form action="deleteCategories" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="category" items="${categories}">
							<option value="${category.categoryId}">${category.categoryId}: ${category.name}</option>
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
		<h3>Assign Product to Category</h3>
		<hr>
		<form action="assignProducts" method="post" class="form-horizontal">
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
				<label for="categoryId" class="col-sm-4 control-label">Category ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="categoryId">
						<c:forEach var="category" items="${categories}">
							<option value="${category.categoryId}">${category.categoryId}: ${category.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
		    	<div class="col-sm-offset-4 col-sm-1">
		    		<button type="submit" class="btn btn-primary">Assign</button>
		  		</div>
			</div>
		</form>
		<h3>Unassign Product from Category</h3>
		<hr>
		<form action="unassignProducts" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="productId" class="col-sm-4 control-label">Product ID</label>
				<div class="col-sm-4">
					<select class="form-control" name="id">
						<c:forEach var="product" items="${products}">
							<option value="${product.productId}">${product.productId}: ${product.name}. ${product.getCategory()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
		    	<div class="col-sm-offset-4 col-sm-1">
		    		<button type="submit" class="btn btn-primary">Unassign</button>
		  		</div>
			</div>
		</form>
        </div>
    </header>

    <jsp:include page="/footer.jsp"/>