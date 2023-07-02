package com.rms.dtos;

public class ProductDTOSend {
	private int productId;
	private String productName;
	private float productPrice;
	private String productStatus;
	private int productCategoryId;
	private String productCategoryName;
	public ProductDTOSend(int productId, String productName, float productPrice, String productStatus,
			int productCategoryId, String productCategoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
		this.productCategoryId = productCategoryId;
		this.productCategoryName = productCategoryName;
	}
	public ProductDTOSend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTOSend(int productId, String productName, float productPrice, String productStatus,
			int productCategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
		this.productCategoryId = productCategoryId;
	}
	@Override
	public String toString() {
		return "ProductDTOSend [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productStatus=" + productStatus + ", productCategoryId=" + productCategoryId
				+ ", productCategoryName=" + productCategoryName + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
	
}
