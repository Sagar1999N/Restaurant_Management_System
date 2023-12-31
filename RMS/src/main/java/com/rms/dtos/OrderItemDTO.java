package com.rms.dtos;

public class OrderItemDTO {

	private int orderItemId;
	private int orderItemOrderId;
	private int orderItemProductId;
	private int orderItemQuantity;
	private float orderItemRate = 0.0f;
	private float orderItemAmount = 0.0f;
	private String orderItemName;
	public OrderItemDTO(int orderItemId, int orderItemOrderId, int orderItemProductId,
			int orderItemQuantity, float orderItemRate, float orderItemAmount, String orderItemName) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemOrderId = orderItemOrderId;
		this.orderItemProductId = orderItemProductId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemRate = orderItemRate;
		this.orderItemAmount = orderItemAmount;
		this.orderItemName = orderItemName;
	}
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItemDTO [orderItemId=" + orderItemId + ", orderItemOrderId=" + orderItemOrderId
				+ ", orderItemProductId=" + orderItemProductId + ", orderItemQuantity=" + orderItemQuantity
				+ ", orderItemRate=" + orderItemRate + ", orderItemAmount=" + orderItemAmount + ", orderItemName="
				+ orderItemName + "]";
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderItemOrderId() {
		return orderItemOrderId;
	}
	public void setOrderItemOrderId(int orderItemOrderId) {
		this.orderItemOrderId = orderItemOrderId;
	}
	public int getOrderItemProductId() {
		return orderItemProductId;
	}
	public void setOrderItemProductId(int orderItemProductId) {
		this.orderItemProductId = orderItemProductId;
	}
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	public float getOrderItemRate() {
		return orderItemRate;
	}
	public void setOrderItemRate(float orderItemRate) {
		this.orderItemRate = orderItemRate;
	}
	public float getOrderItemAmount() {
		return orderItemAmount;
	}
	public void setOrderItemAmount(float orderItemAmount) {
		this.orderItemAmount = orderItemAmount;
	}
	public String getOrderItemName() {
		return orderItemName;
	}
	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}

}
