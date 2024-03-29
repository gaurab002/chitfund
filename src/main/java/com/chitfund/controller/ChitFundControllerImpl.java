package com.chitfund.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitfund.models.CalculateDto;
import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.models.ExistingChitFund;
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
	public List<ChitInfo> getAllChit(@RequestParam("uid") String uid) {
		return chitService.getAllChit(uid);
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

	@Override
	public CalculateDto calculateChit(@RequestParam("id") long i, @RequestParam(defaultValue = "12.5", name="rate") double rate) {
		// TODO Auto-generated method stub
		return chitService.calulateChit(i, rate);
	}

	@Override
	public ExistingChitFund updateChitFund(@RequestBody ExistingChitFund existingChitFund) {
			return chitService.updateChitFund(existingChitFund);
	}

	@Override
	public List<ExistingChitFund> getAllExistingChitFunds(@RequestParam("uid") String uid) {
		return chitService.getAllExistingChitFunds(uid);
	}

	@Override
	public ExistingChitFund deleteChitFund(long id) {
		// TODO Auto-generated method stub
		return chitService.delteChitFund(id);
	}

}
