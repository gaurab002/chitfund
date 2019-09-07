package com.chitfund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.models.ExistingChitFund;


public interface IChitFundService {

	public String createNewChit(ChitInfo chitInfo);
	

	public String addCustomer(Customer customer);
	

	public List<ChitInfo> getAllChit();
	

	public ChitInfo getChitById(Long id);
	

	public String updateChitTerm(ChitDate chitDate);


	public List<Customer> getAllCustomers();


	double calulateChit(int i);


	public ExistingChitFund updateChitFund(ExistingChitFund existingChitFund);


	public List<ExistingChitFund> getAllExistingChitFunds();
}
