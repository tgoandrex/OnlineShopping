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
 
		<h1>Online Shopping <small>View Categories</small></h1>
		<hr>
		<table class="table table-striped table-hover table-responsive shopping-datatable">
			<thead>
				<tr>
					<th class="text-center">Category Id</th>
					<th class="text-center">Category Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${categories}">
					<tr>
						<td><c:out value="${category.categoryId}" /></td>
						<td><c:out value="${category.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	  </div>
	</header>

	<jsp:include page="/footer.jsp" />