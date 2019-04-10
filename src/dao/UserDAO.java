package dao;

import java.util.List;

import model.Order;
import model.User;

public interface UserDAO {
	
	public void registerUser(User user) throws Exception;
	
	public void resetPassword(User user, String password) throws Exception;
	
	List<User> getAllUsers();
	
	public void deleteUser(User user) throws Exception;
	
	public void updateEmail(User user, String email);
	
	public void updateAddress(User user, String address);
	
	public void updatePhone(User user, String phone);
	
	public User getUserByUsername(String username);
	
	List<Order> getUserOrders(User user);
}
