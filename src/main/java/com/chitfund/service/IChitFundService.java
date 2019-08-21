package com.chitfund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;


public interface IChitFundService {

	public String createNewChit(ChitInfo chitInfo);
	

	public String addCustomer(Customer customer);
	

	public List<ChitInfo> getAllChit();
	

	public ChitInfo getChitById(Long id);
	

	public String updateChitTerm(ChitDate chitDate);


	public List<Customer> getAllCustomers();
}
