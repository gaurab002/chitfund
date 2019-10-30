package com.chitfund.pushnotification;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.chitfund.dao.ChitFundDaoImpl;
import com.chitfund.dao.PushNotificationDao;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.DeviceToken;
import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidConfig.Priority;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushConfig.Builder;

@Service
@Transactional
public class PushNotificationService {

	private Map<String, String> defaults;

	@Autowired
	PushNotificationDao pushNotificationDao;

	@Autowired
	ChitFundDaoImpl chitFundDaoImpl;

	private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
	private FCMService fcmService;

	public PushNotificationService(FCMService fcmService) {
		this.fcmService = fcmService;
	}

	@Scheduled(initialDelay = 60000, fixedDelay = 60000)
	public void sendSamplePushNotification() {
		try {
			fcmService.sendMessageWithoutData(getSamplePushNotificationRequest());
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage());
		}
	}

	public void sendPushNotificationWithoutData(PushNotificationRequest request) {
		try {
			fcmService.sendMessageWithoutData(request);
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage());
		}
	}

	private Map<String, String> getSamplePayloadData() {
		Map<String, String> pushData = new HashMap();
		pushData.put("messageId", defaults.get("payloadMessageId"));
		pushData.put("text", defaults.get("payloadData") + " " + LocalDateTime.now());
		return pushData;
	}

	private PushNotificationRequest getSamplePushNotificationRequest() {
		return null;
	}

	public boolean registerDeviceToken(DeviceToken token) {
		// TODO Auto-generated method stub
		if (token != null && token.getToken() != null && token.getToken().length() != 0)
			return pushNotificationDao.addDeviceToken(token);
		else
			return false;
	}

	public void sendPushNotification() throws FirebaseMessagingException {
		// This registration token comes from the client FCM SDKs.
		List<DeviceToken> registrationTokens = pushNotificationDao.getAllTokens();

		List<ChitInfo> filteredList = chitFundDaoImpl.getAllChit().stream()
				.filter(chit -> Calendar.getInstance().DAY_OF_MONTH == chit.getStartDate().getDay())
				.collect(Collectors.toList());

		if (filteredList != null && !filteredList.isEmpty()) {
			// See documentation on defining a message payload.
			Notification notification = new Notification("Today is the chit call day", "get ready with your money and chit call");
			registrationTokens.forEach(token -> {
				WebpushConfig webpushConfig = WebpushConfig.builder().putHeader("Urgency", "high").build();
				AndroidConfig androidConfig = AndroidConfig.builder().setPriority(Priority.HIGH).build();
				Message message = Message.builder().setNotification(notification).setToken(token.getToken())
						.setWebpushConfig(webpushConfig).setAndroidConfig(androidConfig).build();

				// Send a message to the device corresponding to the provided
				// registration token.
				ApiFuture<String> response;
				response = FirebaseMessaging.getInstance().sendAsync(message);
				System.out.println("Successfully sent message: " + response);

			});
		}

	}

}
