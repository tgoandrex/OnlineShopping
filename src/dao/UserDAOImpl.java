package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import model.UserRoles;
import model.Order;
import model.User;

public class UserDAOImpl implements UserDAO {
	
	Session session = HibernateTest.getHibernateSession();
	
	@Override
	public void registerUser(User user) throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		UserRoles userRole = new UserRoles();
		
		boolean success = true;
		
		session.beginTransaction();
		
		userRole.setUser(user);
		userRole.setRole("User");
		
		session.save(user);
		session.save(userRole);
		
		if (username.length() < 8) {
			success = false;
		}
		
		int numNumbers = 0;
		for (int c = 0; c < password.length(); c++) {
		    if ( Character.isDigit(password.charAt(c)) ) {
		    	numNumbers++;
		    }
		}

		if (numNumbers < 2) {
			success = false;
		}
		
		if (success) {
			session.getTransaction().commit();
		} else {
		    throw new Exception();
		}
		
		session.close();
		
	}

	@Override
	public void resetPassword(User user, String password) throws Exception {
		boolean success = true;
		
		session.beginTransaction();
		
		int numNumbers = 0;
		for (int c = 0; c < password.length(); c++) {
		    if ( Character.isDigit(password.charAt(c)) ) {
		    	numNumbers++;
		    }
		}

		if (numNumbers < 2) {
			success = false;
		}
		
		if (success) {
			user.setPassword(password);
			
			session.update(user);
			
			session.getTransaction().commit();
		} else {
		    throw new Exception();
		}
		
		session.close();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String hql = "from User";
		
		TypedQuery<User> query = session.createQuery(hql, User.class);
		
		users = query.getResultList();
		
		session.close();
		
		return users;
	}

	@Override
	public void deleteUser(User user) {
		session.beginTransaction();
		
		session.delete(user);
		session.delete(user.getRole());
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void updateEmail(User user, String email) {
		session.beginTransaction();
		
		user.setEmail(email);
		
		session.update(user);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void updateAddress(User user, String address) {
		session.beginTransaction();
		
		user.setAddress(address);
		
		session.update(user);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Override
	public void updatePhone(User user, String phone) {
		session.beginTransaction();
		
		user.setPhone(phone);
		
		session.update(user);
		
		session.getTransaction().commit();
		
		session.close();
	}

	@Override
	public User getUserByUsername(String username) {
		User user;
		String hql = "from User where username = :user";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("user", username);
		
		user = query.getSingleResult();
		
		return user;
	}
	
	@Override
	public List<Order> getUserOrders(User user) {
		List<Order> orders = new ArrayList<>();
		String hql = "from Order where customerName = :name";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("name", user);
		
		orders = query.getResultList();
		
		session.close();
		
		return orders;
	}
}
