package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Category;
import model.Product;

@WebServlet("admin/assignProducts")
public class AssignProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editCategories.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long productId = Long.parseLong(request.getParameter("productId"));
		final long categoryId = Long.parseLong(request.getParameter("categoryId"));
		
		ProductDAO pDAO = new ProductDAOImpl();
		CategoryDAO cDAO = new CategoryDAOImpl();
		
		Product product = pDAO.getProductByProductId(productId);
		Category category = cDAO.getCategoryByCategoryId(categoryId);
		try {
			pDAO.assignProduct(product, category);
			request.getSession().setAttribute("message", "Product: " + product.getName() + " successfully assigned to category id: " + category.getCategoryId());
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("/OnlineShopping");
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("message", "There was a problem assigning the product at this time.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("editCategories.jsp").forward(request, response);
		}
	}
}