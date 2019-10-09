package com.chitfund.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chitfund.models.DeviceToken;

@Repository
public class PushNotificationDao {
	@Autowired
	EntityManager em;
	
	
	public boolean addDeviceToken(DeviceToken token) {
		em.persist(token);
		em.flush();
		return true;
	}


	public List<DeviceToken> getAllTokens() {
		// TODO Auto-generated method stub
		return em.createQuery("from DeviceToken").getResultList();
	}
}
