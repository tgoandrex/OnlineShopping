package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import model.Order;
import model.Product;
import model.User;

public class OrderDAOImpl implements OrderDAO {
	Session session = HibernateTest.getHibernateSession();
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		String hql = "from Order";
		
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		
		orders = query.getResultList();
		
		session.close();
		
		return orders;
	}
	
	@Override
	public void createOrder(Order order) throws Exception {
		session.beginTransaction();
		
		session.save(order);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void addToOrder(Order order, Product product) throws Exception {
		BigDecimal productPrice = new BigDecimal(0);
		productPrice = product.getPrice();
		
		session.beginTransaction();
		
	    order.getProducts().add(product);
	    product.getOrders().add(order);
	    
	    order.setQuantity(order.getQuantity() + 1);
	    order.setPrice(productPrice.add(order.getPrice()));
	    product.setInventory(product.getInventory() - 1);
	    
	    session.save(order);
	    session.save(product);
	    
	    session.getTransaction().commit();
	    
	    session.close();
	}
	
	@Override
	public void deleteFromOrder(Order order, Product product) throws Exception {
		BigDecimal productPrice = new BigDecimal(0);
		productPrice = product.getPrice();
		
		session.beginTransaction();
		
	    order.getProducts().remove(product);
	    product.getOrders().remove(order);
	    
	    order.setQuantity(order.getQuantity() + 1);
	    order.setPrice(productPrice.subtract(order.getPrice()));
	    product.setInventory(product.getInventory() + 1);
	    
	    session.delete(order);
	    session.delete(product);
	    
	    session.getTransaction().commit();
	    
	    session.close();
	}
	
	@Override
	public void deleteOrder(Order order) throws Exception {
		session.beginTransaction();
		
		order.setCustomerName(null);
		
		order.setProduct(null);
		
		session.delete(order);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void assignOrder(Order order, User user) throws Exception {
		order = session.load(Order.class, order.getOrderId());
		user = session.load(User.class, user.getUsername());
		
		order.setCustomerName(user);
		
		session.beginTransaction();
		
		session.update(order);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public Order getOrderByOrderId(long id) {
		Order order;
		String hql = "from Order where orderId = :id";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id", id);
		
		order = query.getSingleResult();
		
		return order;
	}
}
