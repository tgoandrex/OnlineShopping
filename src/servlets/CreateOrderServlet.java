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

import dao.OrderDAO;
import dao.OrderDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Order;
import model.User;

@WebServlet("user/createOrders")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viewUserOrders.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getUserPrincipal().getName();
		UserDAO uDAO = new UserDAOImpl();
		User user = uDAO.getUserByUsername(username);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp time = Timestamp.valueOf(localDateTime);
		
		final Order order = new Order(new BigDecimal(0), 0, user, time);
		
		OrderDAO oDAO = new OrderDAOImpl();
		try {
			oDAO.createOrder(order);
			request.getSession().setAttribute("message", "Order id: " + order.getOrderId() + " successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem creating the order at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("viewUserOrders.jsp").forward(request, response);
		}
	}
}
