package dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import model.Category;
import model.Product;

public interface ProductDAO {
	
	List<Product> getAllProducts();
	
	public void createProduct(Product product) throws Exception;
	
	public void updateProduct(Product product, String name, long inventory, BigDecimal price, Timestamp createDate) throws Exception;
	
	public void deleteProduct(Product product) throws Exception;
	
	public void assignProduct(Product product, Category category) throws Exception;
	
	public void unassignProduct(Product product) throws Exception;
	
	public Product getProductByProductId(long id);
}
