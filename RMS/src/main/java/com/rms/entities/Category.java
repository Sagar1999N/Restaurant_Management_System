package com.rms.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  categoryId;
	private String  categoryName;
	private String  categoryStatus="Enabled";
	@OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
	private List<Product> productList;
	public Category() {
	}
	public Category(int categoryId) {
		super();
		this.categoryId = categoryId;
	}
	public Category(int categoryId, String categoryName, String categoryStatus) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
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
	public String getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return String.format("Category [categoryId=%s, categoryName=%s, categoryStatus=%s]", categoryId, categoryName,
				categoryStatus);
	}
}




	
	
	
	

