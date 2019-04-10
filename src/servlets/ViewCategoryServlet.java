package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import model.Category;

@WebServlet("user/viewCategories")
public class ViewCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAOImpl();
		List<Category> category = dao.getAllCategories();

		request.getSession().setAttribute("categories", category);
		
		request.getRequestDispatcher("viewCategories.jsp").forward(request, response);
	}
}
