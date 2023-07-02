package com.rms.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private float taxAndCharge;
	private float discount;
	private float billAmount;
	private float billTotal;
	private Date billDate;
	private String billPaymentMethod;
	private String billStatus;
	@OneToOne
	@JoinColumn(name = "billOrderId")
	private Orders billOrder;
	@ManyToOne
	@JoinColumn(name = "billCashierId")
	private User billCashier;
	
	public Bill(int billId, float taxAndCharge, float discount, float billAmount, float billTotal,
			Date billDate, String billPaymentMethod, String billStatus, Orders billOrder, User billCashier) {
		super();
		this.billId = billId;
		this.taxAndCharge = taxAndCharge;
		this.discount = discount;
		this.billAmount = billAmount;
		this.billTotal = billTotal;
		this.billDate = billDate;
		this.billPaymentMethod = billPaymentMethod;
		this.billStatus = billStatus;
		this.billOrder = billOrder;
		this.billCashier = billCashier;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billAmount="
				+ billAmount + ", billTotal=" + billTotal + "]";
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public float getTaxAndCharge() {
		return taxAndCharge;
	}
	public void setTaxAndCharge(float taxAndCharge) {
		this.taxAndCharge = taxAndCharge;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public float getBillTotal() {
		return billTotal;
	}
	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBillPaymentMethod() {
		return billPaymentMethod;
	}
	public void setBillPaymentMethod(String billPaymentMethod) {
		this.billPaymentMethod = billPaymentMethod;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public Orders getBillOrder() {
		return billOrder;
	}
	public void setBillOrder(Orders billOrder) {
		this.billOrder = billOrder;
	}
	public User getBillCashier() {
		return billCashier;
	}
	public void setBillCashier(User billCashier) {
		this.billCashier = billCashier;
	}
	
	
}
