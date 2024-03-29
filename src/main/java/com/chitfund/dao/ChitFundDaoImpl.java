package com.chitfund.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;
import com.chitfund.models.ExistingChitFund;

@Repository
public class ChitFundDaoImpl implements IChitFundDao {

	@Autowired
	EntityManager em;

	@Override
	public String createNewChit(ChitInfo chitInfo) {
		em.persist(chitInfo);
		em.flush();
		return "saved";
	}

	@Override
	public String addCustomer(Customer customer) {
		em.persist(customer);
		em.flush();
		return "Customer added successfuly!";
	}

	@Override
	public List<ChitInfo> getAllChit() {
		// TODO Auto-generated method stub
		return em.createQuery("from ChitInfo").getResultList();
	}

	@Override
	public ChitInfo getChitById(Long id) {
		return em.find(ChitInfo.class, id);
	}

	@Override
	public String updateChitTerm(ChitDate chitDate) {
		em.persist(chitDate);
		em.flush();
		return "saved";
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return em.createQuery("from Customer").getResultList();
	}

	@Override
	public ExistingChitFund updateChitFund(ExistingChitFund existingChitFund) {
		em.merge(existingChitFund);
		em.flush();
		return existingChitFund;
	}

	@Override
	public List<ExistingChitFund> getAllExistingChitFunds(String uid) {
		// TODO Auto-generated method stub
		return em.createQuery("from ExistingChitFund WHERE uid = :uid").setParameter("uid", uid).getResultList();
	}

	@Override
	public ExistingChitFund deleteChitFund(long id) {
		// TODO Auto-generated method stub

		ExistingChitFund existingChitFund = em.find(ExistingChitFund.class, id);
		;
		em.remove(existingChitFund);
		em.flush();
		return existingChitFund;
	}

	@Override
	public ExistingChitFund getExistingChitFund(long i) {
		// TODO Auto-generated method stub
		return em.find(ExistingChitFund.class, i);
	}

}
