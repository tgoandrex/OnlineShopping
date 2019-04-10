package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
    @JoinTable(
        name = "orders_products", 
        joinColumns = { @JoinColumn(name = "order_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
	private Set<Product> products;
	
	@Id
	@SequenceGenerator(name="orderSeq",sequenceName="orders_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSeq")
	@Column(name="id")
	private long orderId;
	
	@Column
	private BigDecimal price;
	@Column
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_name")
	private User customerName;
	
	@Column(name="order_date")
	private Timestamp orderDate;
	
	public Order() {};
	
	public Order(BigDecimal price, int quantity, User customerName, Timestamp orderDate) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.customerName = customerName;
		this.orderDate = orderDate;
	}
	
	public Set<Product> getProducts () { 
        return products; 
    }
	
	public void setProduct(Set<Product> products) {
		this.products = products;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public User getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(User customerName) {
		this.customerName = customerName;
	}
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + orderId + ", Price: " + price + ", Quantity: " + quantity +  ", Price: " + price + ", Customer Name : " + customerName + ", Order Date: " + orderDate;
	}
}