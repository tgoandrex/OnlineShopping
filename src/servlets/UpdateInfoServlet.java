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

@WebServlet("user/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getUserPrincipal().getName();
		
		UserDAO dao = new UserDAOImpl();
		User user = dao.getUserByUsername(username);
		
		request.getSession().setAttribute("user", user);
		
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}
}