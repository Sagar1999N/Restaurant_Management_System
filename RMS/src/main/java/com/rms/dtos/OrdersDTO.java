package com.rms.dtos;

public class OrdersDTO {
	private int orderId;
	private String orderStatus = "Pending";
	private int orderServicePersonId;
	private int orderTableId;
	private String orderTableName;
	public OrdersDTO(int orderId, String orderStatus, int orderServicePersonId, int orderTableId,
			String orderTableName) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderServicePersonId = orderServicePersonId;
		this.orderTableId = orderTableId;
		this.orderTableName = orderTableName;
	}
	
	public OrdersDTO(int orderId) {
		super();
		this.orderId = orderId;
	}
	public OrdersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderServicePersonId="
				+ orderServicePersonId + ", orderTableId=" + orderTableId + ", orderTableName=" + orderTableName + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderServicePersonId() {
		return orderServicePersonId;
	}
	public void setOrderServicePersonId(int orderServicePersonId) {
		this.orderServicePersonId = orderServicePersonId;
	}
	public int getOrderTableId() {
		return orderTableId;
	}
	public void setOrderTableId(int orderTableId) {
		this.orderTableId = orderTableId;
	}
	public String getOrderTableName() {
		return orderTableName;
	}
	public void setOrderTableName(String orderTableName) {
		this.orderTableName = orderTableName;
	}

	
}
