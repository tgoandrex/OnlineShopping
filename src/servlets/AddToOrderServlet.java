package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Order;
import model.Product;

@WebServlet("user/addToOrders")
public class AddToOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long orderId = Long.parseLong(request.getParameter("orderId"));
		final long productId = Long.parseLong(request.getParameter("productId"));
		
		OrderDAO oDAO = new OrderDAOImpl();
		ProductDAO pDAO = new ProductDAOImpl();
		
		Order order = oDAO.getOrderByOrderId(orderId);
		Product product = pDAO.getProductByProductId(productId);
		try {
			oDAO.addToOrder(order, product);
			
			request.getSession().setAttribute("message", "Product: " + product.getName() + " successfully added to order id: " + order.getOrderId());
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
			} catch (Exception e){
				e.printStackTrace();
			
				request.getSession().setAttribute("message", "There was a problem adding the product to the order at this time");
				request.getSession().setAttribute("messageClass", "alert-danger");
			
				request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
		  }
	}
}