package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Order;
import model.Product;
import model.User;

@WebServlet("user/viewProducts")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getUserPrincipal().getName();
		
		UserDAO uDAO = new UserDAOImpl();
		
		User user = uDAO.getUserByUsername(username);
		List<Order> orders = uDAO.getUserOrders(user);
		
		ProductDAO pDAO = new ProductDAOImpl();
		List<Product> products = pDAO.getAllProducts();
		
		request.getSession().setAttribute("products", products);
		request.getSession().setAttribute("orders", orders);
		request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
	}
}
