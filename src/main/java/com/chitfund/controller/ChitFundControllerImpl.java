package com.chitfund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.service.IChitFundService;

@RestController
public class ChitFundControllerImpl implements IChitFundController{
	
	@Autowired
	IChitFundService chitService;

	@Override
	public String createNewChit(@RequestBody ChitInfo chitInfo) {
		return chitService.createNewChit(chitInfo);
		
	}

	@Override
	public String addCustomer(@RequestBody Customer customer) {
		return chitService.addCustomer(customer);
	}

	@Override
	public List<ChitInfo> getAllChit() {
		return chitService.getAllChit();
	}

	@Override
	public ChitInfo getChitById(Long id) {
		return chitService.getChitById(id);
	}

	@Override
	public String updateChitTerm(@RequestBody ChitDate chitDate) {
		return chitService.updateChitTerm(chitDate);
	}


	@Override
	public List<Customer> getAllCustomers() {
		return chitService.getAllCustomers();
	}

}