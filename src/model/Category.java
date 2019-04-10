package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@JoinColumn(name="category_id")
	@SequenceGenerator(name="categorySeq",sequenceName="category_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categorySeq")
	@Column(name="id")
	private long categoryId;
	
	@Column
	private String name;
	
	public Category() {};
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category ID: " + categoryId + ", Name: " + name;
	}
}
