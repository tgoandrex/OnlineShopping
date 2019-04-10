package model;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@ManyToMany(mappedBy ="products", fetch=FetchType.EAGER)
    private Set<Order> orders;
	
	@Id
	@SequenceGenerator(name="productSeq",sequenceName="products_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
	@Column(name="id")
	private long productId;
	
	@Column
	private String name;
	@Column(name="create_date")
	private Timestamp createDate;
	@Column
	private BigDecimal price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category categoryId;
	
	@Column
	private long inventory;
	
	public Product() {};
	
	public Product(String name, Timestamp createDate, BigDecimal price, long inventory) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.price = price;
		this.inventory = inventory;
	}
	
	public Set<Order> getOrders () { 
        return orders; 
    }
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return categoryId;
	}
	
	public void setCategory(Category categoryId) {
		this.categoryId = categoryId;
	}
	
	public long getInventory() {
		return inventory;
	}
	
	public void setInventory(long inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public String toString() {
		return "Product ID: " + productId + ", Name: " + name + ", Price: $" + price;
	}
}
