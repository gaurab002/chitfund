package com.chitfund.pushnotification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationSchedular {

private static final Logger logger  = LoggerFactory.getLogger(PushNotificationSchedular.class);

	
	@Scheduled(cron = "*/10 * * * * *")
	public void cronJobs() {
		logger.info("hi");
	}
}
