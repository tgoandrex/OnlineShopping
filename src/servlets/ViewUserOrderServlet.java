package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.Order;
import model.User;

@WebServlet("user/viewUserOrders")
public class ViewUserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getUserPrincipal().getName();
		
		UserDAO dao = new UserDAOImpl();
		
		User user = dao.getUserByUsername(username);
		
		List<Order> orders = dao.getUserOrders(user);

		request.getSession().setAttribute("orders", orders);
		
		request.getRequestDispatcher("viewUserOrders.jsp").forward(request, response);
	}
}