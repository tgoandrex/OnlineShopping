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

@WebServlet("admin/updateCategories")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editCategories.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long id = Long.parseLong(request.getParameter("id"));
		final String name = request.getParameter("name");
		
		CategoryDAO dao = new CategoryDAOImpl();
		
		final Category category = dao.getCategoryByCategoryId(id);
		try {
			dao.updateCategory(category, name);
			request.getSession().setAttribute("message", "Category id: " + category.getCategoryId() + " successfully updated");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem updating the category at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("editCategories.jsp").forward(request, response);
		}
	}
}