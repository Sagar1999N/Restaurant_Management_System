package com.rms.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String role;
	private Date createdDate;	
	private String currentStatus;
	@OneToMany(mappedBy = "waiter", cascade = CascadeType.REMOVE)
	private List<Tables> tableList;
	@OneToMany(mappedBy = "orderServicePerson", cascade = CascadeType.REMOVE)
	private List<Orders> orderdList;
	@OneToMany(mappedBy = "billCashier", cascade = CascadeType.REMOVE)
	private List<Bill> billList;
	public User() {
	}
	public User(int userId)
	{
		super();
		this.userId = userId;	
	}

	public User(int userId, String name, String email, String phone, String password, String role,
			Date date, String currentStatus, List<Tables> tableList) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;//Roles.convert(role);
		this.createdDate = date;
		this.currentStatus = currentStatus;
		this.tableList = tableList;
	}


	public User(int userId, String name, String email, String phone, String password, String role,
			Date date, String currentStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;//Roles.convert(role);
		this.createdDate = date;
		this.currentStatus = currentStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;//Roles.convert(role);
	}
	public Date getDate() {
		return createdDate;
	}
	public void setDate(Date date) {
		this.createdDate = date;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public List<Tables> getTableList() {
		return tableList;
	}
	public void setTableList(List<Tables> tableList) {
		this.tableList = tableList;
	}
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
//				+ password + ", role=" + role + ", createdDate=" + createdDate + ", currentStatus=" + currentStatus
//				+ ", tableList=" + tableList + ", orderdList=" + orderdList + ", billList=" + billList + "]";
//	}
}
