package com.chitfund.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitfund.dao.IChitFundDao;
import com.chitfund.models.CalculateDto;
import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.models.ExistingChitFund;
import com.chitfund.models.ExistingChitFundCall;

@Service
@Transactional
public class ChitFundServiceImpl implements IChitFundService {

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

	@Override
	public CalculateDto calulateChit(long i, double rate) {
		CalculateDto calculateDto = new CalculateDto();
		ExistingChitFund existingChitFund = chitFundDao.getExistingChitFund(i);
		double amount = existingChitFund.getAmount();
		double lastDiduAmt = existingChitFund.getLastWillDiductAmt();
		int terms = existingChitFund.getNoOfMonths();
		double totalProfit = 0;

		if (existingChitFund.getExistingChitFundCalls() != null) {
			totalProfit = existingChitFund.getExistingChitFundCalls().stream()
					.map(existingChitFundCall -> existingChitFundCall.getCalledAmount()).mapToDouble(Double::valueOf)
					.sum();
			double x = 0, y = 0;
			int z = existingChitFund.getExistingChitFundCalls().size() - 1;
			double l = existingChitFund.getExistingChitFundCalls().get(z).getCalledAmount();
			while (x >= y) {
				x = l * terms;
				y = (((terms * amount) - (l * terms)) / 1000) * rate * (terms - z) + l - 500;
				l = l - 50;
			}

			calculateDto.setTotalProfitSoFar(totalProfit);
			calculateDto.setProfitOnKeep(x);
			calculateDto.setProfitOnCall(y);
			calculateDto.setAmountToBeCalled(l * terms);
		}

		return calculateDto;
	}

	@Override
	public ExistingChitFund updateChitFund(ExistingChitFund existingChitFund) {
		return chitFundDao.updateChitFund(existingChitFund);
	}

	@Override
	public List<ExistingChitFund> getAllExistingChitFunds() {
		return chitFundDao.getAllExistingChitFunds();
	}

	@Override
	public ExistingChitFund delteChitFund(long id) {
		// TODO Auto-generated method stub
		return chitFundDao.deleteChitFund(id);
	}

}
