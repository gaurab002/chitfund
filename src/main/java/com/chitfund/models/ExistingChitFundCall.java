package com.chitfund.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExistingChitFundCall {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private Date callDate;
	private double calledAmount;
	private String calledPerson;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public double getCalledAmount() {
		return calledAmount;
	}

	public void setCalledAmount(double calledAmount) {
		this.calledAmount = calledAmount;
	}

	public String getCalledPerson() {
		return calledPerson;
	}

	public void setCalledPerson(String calledPerson) {
		this.calledPerson = calledPerson;
	}

}
