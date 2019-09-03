package com.chitfund.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class ExistingChitFund {

	@Id
	private int id;
	
	private Date startDate;
	
	private int noOfMonths;
	
	private double amount;
	
	private double lastWillDiductAmt;
	
	@OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private List<ExistingChitFundCall> existingChitFundCalls;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getLastWillDiductAmt() {
		return lastWillDiductAmt;
	}

	public void setLastWillDiductAmt(double lastWillDiductAmt) {
		this.lastWillDiductAmt = lastWillDiductAmt;
	}

	public List<ExistingChitFundCall> getExistingChitFundCalls() {
		return existingChitFundCalls;
	}

	public void setExistingChitFundCalls(List<ExistingChitFundCall> existingChitFundCalls) {
		this.existingChitFundCalls = existingChitFundCalls;
	}
	
	
	
	
}
