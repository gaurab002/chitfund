package com.chitfund.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ChitDate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private ChitInfo chitInfo;
	
	private Date chitDate;
	
	@OneToOne
	private Customer customer;
	
	private Double calledAmt;
	
	private Double profitAmt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChitInfo getChitInfo() {
		return chitInfo;
	}

	public void setChitInfo(ChitInfo chitInfo) {
		this.chitInfo = chitInfo;
	}

	public Date getChitDate() {
		return chitDate;
	}

	public void setChitDate(Date chitDate) {
		this.chitDate = chitDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getCalledAmt() {
		return calledAmt;
	}

	public void setCalledAmt(Double calledAmt) {
		this.calledAmt = calledAmt;
	}

	public Double getProfitAmt() {
		return profitAmt;
	}

	public void setProfitAmt(Double profitAmt) {
		this.profitAmt = profitAmt;
	}
	
}
