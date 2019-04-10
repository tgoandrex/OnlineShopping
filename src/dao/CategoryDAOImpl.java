package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import dao.HibernateTest;

import model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	Session session = HibernateTest.getHibernateSession();
	
	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		String hql = "from Category";
		
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		
		categories = query.getResultList();
		
		session.close();
		
		return categories;
		}
	
	@Override
	public void createCategory(Category category) throws Exception {
		session.beginTransaction();
		
		session.save(category);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void updateCategory(Category category, String name) throws Exception {
		session.beginTransaction();
		
		category.setName(name);
		
		session.update(category);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void deleteCategory(Category category) throws Exception {
		session.beginTransaction();
		
		session.delete(category);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public Category getCategoryByCategoryId(long id) {
		Category category;
		String hql = "from Category where categoryId = :id";
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		query.setParameter("id", id);
		
		category = query.getSingleResult();
		
		return category;
	}
}
