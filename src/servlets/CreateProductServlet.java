package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

@WebServlet("admin/createProducts")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editProducts.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter("name");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp createDate = Timestamp.valueOf(localDateTime);
		
		final String stringPrice = request.getParameter("price");
		final BigDecimal price = new BigDecimal(stringPrice);
		
		final long inventory = Long.parseLong(request.getParameter("inventory"));
		
		final Product product = new Product(name, createDate, price, inventory);
		
		ProductDAO dao = new ProductDAOImpl();
		try {
			dao.createProduct(product);
			request.getSession().setAttribute("message", "Product: " + product.getName() + " successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem creating the product at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("editProducts.jsp").forward(request, response);
		}
	}
}