package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

@WebServlet("admin/deleteUsers")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getParameter("name");
		
		UserDAO dao = new UserDAOImpl();
		User user = dao.getUserByUsername(username);
		try {
			dao.deleteUser(user);
			request.getSession().setAttribute("message", "User: " + user.getUsername() + " successfully deleted");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem deleting the user at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
		}
	}
}
