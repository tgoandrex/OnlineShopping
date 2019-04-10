package dao;

import java.util.List;

import model.Order;
import model.Product;
import model.User;

public interface OrderDAO {
	List<Order> getAllOrders();
	
	public void createOrder(Order order) throws Exception;
	
	public void addToOrder(Order order, Product product) throws Exception;
	
	public void deleteFromOrder(Order order, Product product) throws Exception;
	
	public void deleteOrder(Order order) throws Exception;
	
	public void assignOrder(Order order, User user) throws Exception;
	
	public Order getOrderByOrderId(long id);
}
