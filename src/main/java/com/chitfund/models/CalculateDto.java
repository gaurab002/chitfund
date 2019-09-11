package com.chitfund.models;

public class CalculateDto {
	
	private double totalProfitSoFar;
	
	private double amountToBeCalled;
	
	private double profitOnKeep;
	
	private double profitOnCall;

	public double getTotalProfitSoFar() {
		return totalProfitSoFar;
	}

	public void setTotalProfitSoFar(double totalProfitSoFar) {
		this.totalProfitSoFar = totalProfitSoFar;
	}

	public double getAmountToBeCalled() {
		return amountToBeCalled;
	}

	public void setAmountToBeCalled(double amountToBeCalled) {
		this.amountToBeCalled = amountToBeCalled;
	}

	public double getProfitOnKeep() {
		return profitOnKeep;
	}

	public void setProfitOnKeep(double profitOnKeep) {
		this.profitOnKeep = profitOnKeep;
	}

	public double getProfitOnCall() {
		return profitOnCall;
	}

	public void setProfitOnCall(double profitOnCall) {
		this.profitOnCall = profitOnCall;
	}
	
	
}
