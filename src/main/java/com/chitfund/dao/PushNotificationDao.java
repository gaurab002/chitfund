package com.chitfund.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chitfund.models.ChitInfo;
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
}
