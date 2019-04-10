package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import model.Order;

@WebServlet("admin/viewOrders")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO dao = new OrderDAOImpl();
		List<Order> orders = dao.getAllOrders();

		request.getSession().setAttribute("orders", orders);
		
		request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
	}
}
