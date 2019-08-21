package com.chitfund.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitfund.dao.IChitFundDao;
import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;

@Service
@Transactional
public class ChitFundServiceImpl implements IChitFundService{

	@Autowired
	IChitFundDao chitFundDao;
	
	@Override
	public String createNewChit(ChitInfo chitInfo) {
		return chitFundDao.createNewChit(chitInfo);
	}

	@Override
	public String addCustomer(Customer customer) {
		return chitFundDao.addCustomer(customer);
	}

	@Override
	public List<ChitInfo> getAllChit() {
		// TODO Auto-generated method stub
		return chitFundDao.getAllChit();
	}

	@Override
	public ChitInfo getChitById(Long id) {
		// TODO Auto-generated method stub
		return chitFundDao.getChitById(id);
	}

	@Override
	public String updateChitTerm(ChitDate chitDate) {
		// TODO Auto-generated method stub
		return chitFundDao.updateChitTerm(chitDate);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return chitFundDao.getAllCustomers();
	}

}