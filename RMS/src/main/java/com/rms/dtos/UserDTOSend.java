package com.rms.dtos;

import java.sql.Date;

public class UserDTOSend {
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String role;
	private String currentStatus = "Enabled";
	private Date createdDate;
	public UserDTOSend(int userId, String name, String email, String phone, String role, String currentStatus,
			Date createdDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;//Roles.convert(role);
		this.currentStatus = currentStatus;
		this.createdDate = createdDate;
	}
	public UserDTOSend(int userId, String name, String email, String phone, String role, String currentStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;//Roles.convert(role);
		this.currentStatus = currentStatus;
	}
	@Override
	public String toString() {
		return "UserDTOSend [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", role="
				+ role + ", currentStatus=" + currentStatus + "]";
	}
	public UserDTOSend() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;//Roles.convert(role);
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
//	public void setRole(Roles role) {
//		this.role = role;		
//	}
	
	
}
