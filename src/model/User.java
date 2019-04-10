package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.UserRoles;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@JoinColumn(name="customer_name")
	private String username;
	@Column
	private String password;
	
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="user")
	private UserRoles userRole;
	
	public User() {};
	
	public User(String username, String password, String email, String address, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public UserRoles getRole() {
		return userRole;
	}

	public void setRole(UserRoles userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "Username: " + username;
	}
}
