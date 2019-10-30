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
		List<DeviceToken> deviceTokens = em.createQuery("from DeviceToken").getResultList();
		DeviceToken deviceToken = new DeviceToken();
		deviceToken.setToken("cHX2QhOFJhM:APA91bFB7i2PaF3MM8SIRsgzV176453AqlAu-YGBbRsul7mvJwkx_KEt3gn-Xi7ILSRpZ3Vv8GQu1NR3ixDC1eohPh0zVIDpWc1lp5Br2m287RjPe8g7oTAI5EZYoti6dcP37gfyEJaK");
		deviceTokens.add(deviceToken);
		return deviceTokens;
	}
}
