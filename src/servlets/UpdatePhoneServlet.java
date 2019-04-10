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

@WebServlet("user/updatePhone")
public class UpdatePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getUserPrincipal().getName();
		
		final String phone = request.getParameter("phone");
		
		UserDAO dao = new UserDAOImpl();
		User user = dao.getUserByUsername(username);
		try {
			dao.updatePhone(user, phone);
			request.getSession().setAttribute("message", "User phone number: " + user.getPhone() + " successfully updated");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem updating your phone number at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
		}
	}
}