package com.practice.hibernet.hibernet01.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int categoryId;
	
	@Column(name="category_name")
	String categoryName;
	
	@OneToMany(mappedBy="category",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Product> products;
	
	Category(){
		
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "\nCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	// add convenience methods for bi-directional relationship
	
		public void add(Product product) {
			
			if (products == null) {
				products = new ArrayList<Product>();
			}
			
			products.add(product);
			
			product.setCategory(this);
		}
	
}
