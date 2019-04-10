package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import model.Order;

@WebServlet("admin/deleteOrders")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long id = Long.parseLong(request.getParameter("id"));
		
		OrderDAO dao = new OrderDAOImpl();
		Order order = dao.getOrderByOrderId(id);
		try {
			dao.deleteOrder(order);
			request.getSession().setAttribute("message", "Order id: " + order.getOrderId() +" successfully deleted");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem deleting the order at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
		}
	}
}
