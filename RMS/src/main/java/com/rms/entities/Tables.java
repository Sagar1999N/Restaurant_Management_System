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
import jakarta.persistence.Table;

@Entity
@Table(name = "tables")
public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableId;
	private String tableName;
	private int tableCapacity;
	@ManyToOne
	@JoinColumn(name = "waiterId")
	private User waiter;
	@OneToMany(mappedBy = "orderTable", cascade = CascadeType.REMOVE)
	private List<Orders> ordersList;
	private String tableStatus;

	public Tables() {
		// TODO Auto-generated constructor stub
	}


	public Tables(int tableId) {
		super();
		this.tableId = tableId;
	}


	public Tables(int tableId, String tableName, int tableCapacity, User waiter, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.waiter = waiter;
		this.tableStatus = tableStatus;
	}


	public Tables(int tableId, String tableName, int tableCapacity, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.tableStatus = tableStatus;
	}public int getTableId() {
		return tableId;
	}


	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public int getTableCapacity() {
		return tableCapacity;
	}


	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}


	public User getWaiter() {
		return waiter;
	}


	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}


	public String getTableStatus() {
		return tableStatus;
	}


	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}


	@Override
	public String toString() {
		return String.format("Tables [tableId=%s, tableName=%s, tableCapacity=%s, waiter=%s, tableStatus=%s]", tableId,
				tableName, tableCapacity, waiter, tableStatus);
	}
	
	
	
	
	
	
}
