package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import model.Category;

@WebServlet("admin/createCategories")
public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editCategories.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter("name");
		
		final Category category = new Category(name);
		
		CategoryDAO dao = new CategoryDAOImpl();
		try {
			dao.createCategory(category);
			request.getSession().setAttribute("message", "Category: " + category.getName() + " successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem creating the category at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("editCategories.jsp").forward(request, response);
		}
	}
}