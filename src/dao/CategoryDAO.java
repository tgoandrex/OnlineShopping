package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	List<Category> getAllCategories();
	
	public void createCategory(Category category) throws Exception;
	
	public void updateCategory(Category category, String name) throws Exception;
	
	public void deleteCategory(Category category) throws Exception;
	
	public Category getCategoryByCategoryId(long id);
}
