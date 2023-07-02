package com.rms.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderStatus;
	@ManyToOne
	@JoinColumn(name = "orderServicePersonId")
	private User orderServicePerson;
	@ManyToOne
	@JoinColumn(name = "orderTableId")
	private Tables orderTable;
	@OneToMany(mappedBy = "orderItemOrder",cascade = CascadeType.REMOVE)
	private List<OrderItem> ordersItemList;
	@OneToOne(mappedBy = "billOrder",cascade = CascadeType.REMOVE)
	private Bill orderBill;
	public Orders(int orderId, String orderStatus, User orderServicePerson, Tables orderTable,
			List<OrderItem> ordersItemList, Bill orderBill) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderServicePerson = orderServicePerson;
		this.orderTable = orderTable;
		this.ordersItemList = ordersItemList;
		this.orderBill = orderBill;
	}
	public Orders(int orderId,  String orderStatus, User orderServicePerson, Tables orderTable) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderServicePerson = orderServicePerson;
		this.orderTable = orderTable;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderId) {
		super();
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderServicePerson="
				+ orderServicePerson + ", orderTable=" + orderTable + ", ordersItemList=" + ordersItemList
				+ ", orderBill=" + orderBill + "]";
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
	public User getOrderServicePerson() {
		return orderServicePerson;
	}
	public void setOrderServicePerson(User orderServicePerson) {
		this.orderServicePerson = orderServicePerson;
	}
	public Tables getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(Tables orderTable) {
		this.orderTable = orderTable;
	}
	public List<OrderItem> getOrdersItemList() {
		return ordersItemList;
	}
	public void setOrdersItemList(List<OrderItem> ordersItemList) {
		this.ordersItemList = ordersItemList;
	}
	public Bill getOrderBill() {
		return orderBill;
	}
	public void setOrderBill(Bill orderBill) {
		this.orderBill = orderBill;
	}
	
	
}
