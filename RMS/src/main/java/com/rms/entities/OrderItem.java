package com.rms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	private int orderItemQuantity;
	private float orderItemAmount;
	@ManyToOne
	@JoinColumn(name = "orderItemOrderId")
	private Orders orderItemOrder;
	@ManyToOne
	@JoinColumn(name = "orderItemProductId")
	private Product orderItemProduct;
	public OrderItem(int orderItemId, int orderItemQuantity, float orderItemAmount, Orders orderItemOrder,
			Product orderItemProduct) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemAmount = orderItemAmount;
		this.orderItemOrder = orderItemOrder;
		this.orderItemProduct = orderItemProduct;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemQuantity=" + orderItemQuantity
				+ ", orderItemAmount=" + orderItemAmount + ", orderItemOrder=" + orderItemOrder + ", orderItemProduct="
				+ orderItemProduct + "]";
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	public float getOrderItemAmount() {
		return orderItemAmount;
	}
	public void setOrderItemAmount(float orderItemAmount) {
		this.orderItemAmount = orderItemAmount;
	}
	public Orders getOrderItemOrder() {
		return orderItemOrder;
	}
	public void setOrderItemOrder(Orders orderItemOrder) {
		this.orderItemOrder = orderItemOrder;
	}
	public Product getOrderItemProduct() {
		return orderItemProduct;
	}
	public void setOrderItemProduct(Product orderItemProduct) {
		this.orderItemProduct = orderItemProduct;
	}
	
	
}
