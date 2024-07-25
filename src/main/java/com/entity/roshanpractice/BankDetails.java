package com.entity.roshanpractice;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_emp_data")
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bid;
	@Column(name="bank_name")
	String bankName;
	@Column(name="bank_address")
	String bankAddress;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	@Override
	public String toString() {
		return "BankDetails [bid=" + bid + ", bankName=" + bankName + ", bankAddress=" + bankAddress + "]";
	}
	public BankDetails(int bid, String bankName, String bankAddress) {
		super();
		this.bid = bid;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
	}
	public BankDetails() {
		super();
	}
	
}
