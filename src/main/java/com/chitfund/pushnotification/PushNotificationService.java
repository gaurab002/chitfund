package com.chitfund.pushnotification;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.chitfund.dao.PushNotificationDao;
import com.chitfund.models.DeviceToken;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;



@Service
@Transactional
public class PushNotificationService {

    private Map<String, String> defaults;
    
    
    @Autowired
    PushNotificationDao pushNotificationDao;

    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    @Scheduled(initialDelay = 60000, fixedDelay = 60000)
    public void sendSamplePushNotification() {
     
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


	public boolean registerDeviceToken(DeviceToken token) {
		// TODO Auto-generated method stub
		if(token != null && token.getToken() != null && token.getToken().length() != 0)
		return pushNotificationDao.addDeviceToken(token);
		else return false;
	}

	public void sendPushNotification() throws FirebaseMessagingException {
		// This registration token comes from the client FCM SDKs.
		List<DeviceToken> registrationTokens = pushNotificationDao.getAllTokens();

		// See documentation on defining a message payload.
		registrationTokens.forEach(token -> {
			Message message = Message.builder()
				    .putData("score", "850")
				    .putData("time", "2:45")
				    .setToken(token.getToken())
				    .build();

				// Send a message to the device corresponding to the provided
				// registration token.
				String response;
				try {
					response = FirebaseMessaging.getInstance().send(message);
					System.out.println("Successfully sent message: " + response);
				} catch (FirebaseMessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Response is a message ID string.
			
		});
	
		
	}


}
