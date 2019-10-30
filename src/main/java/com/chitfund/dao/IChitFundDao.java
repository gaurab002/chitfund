package com.chitfund.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.models.ExistingChitFund;


public interface IChitFundDao {
	
	public String createNewChit(ChitInfo chitInfo);
	

	public String addCustomer(Customer customer);
	

	public List<ChitInfo> getAllChit();
	

	public ChitInfo getChitById(Long id);
	

	public String updateChitTerm(ChitDate chitDate);


	public List<Customer> getAllCustomers();


	public ExistingChitFund updateChitFund(ExistingChitFund existingChitFund);


	public List<ExistingChitFund> getAllExistingChitFunds(String uid);


	public ExistingChitFund deleteChitFund(long id);


	public ExistingChitFund getExistingChitFund(long i);

}
