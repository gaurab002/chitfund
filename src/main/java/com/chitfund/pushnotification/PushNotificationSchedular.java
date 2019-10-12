package com.chitfund.pushnotification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.firebase.messaging.FirebaseMessagingException;

@Component
public class PushNotificationSchedular {

	@Autowired
	private PushNotificationService pushNotificationService;
	private static final Logger logger = LoggerFactory.getLogger(PushNotificationSchedular.class);

	@Scheduled(cron = "*/10 * * * * *")
	public void cronJobs() throws FirebaseMessagingException {
		pushNotificationService.sendPushNotification();
	}
}
