package dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import model.Category;
import model.Product;

public class ProductDAOImpl implements ProductDAO {
	Session session = HibernateTest.getHibernateSession();
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String hql = "from Product";
		
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		
		products = query.getResultList();
		
		session.close();
		
		return products;
	}
	
	@Override
	public void createProduct(Product product) throws Exception {
		session.beginTransaction();
		
		session.save(product);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void updateProduct(Product product, String name, long inventory, BigDecimal price, Timestamp createDate) throws Exception {
		session.beginTransaction();
		
		product.setName(name);
		product.setInventory(inventory);
		product.setPrice(price);
		product.setCreateDate(createDate);
		
		session.update(product);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void deleteProduct(Product product) throws Exception {
		session.beginTransaction();
		
		product.setCategory(null);
		
		session.delete(product);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void assignProduct(Product product, Category category) throws Exception {
		product = session.load(Product.class, product.getProductId());
		category = session.load(Category.class, category.getCategoryId());
		
		product.setCategory(category);
		
		session.beginTransaction();
		
		session.update(product);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void unassignProduct(Product product) throws Exception {
		
		Session session = HibernateTest.getHibernateSession();
		
		product = session.load(Product.class, product.getProductId());

	    session.beginTransaction();
	    
	    product.setCategory(null);
	    
	    session.update(product);
	    
	    session.getTransaction().commit();
	    
	    session.close();
	}
	
	@Override
	public Product getProductByProductId(long id) {
		Product product;
		String hql = "from Product where productId = :id";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("id", id);
		
		product = query.getSingleResult();
		
		return product;
	}
}
