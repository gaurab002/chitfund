package com.chitfund.pushnotification;

public class PushNotificationResponse {

	int value;
	String message;
	
	public PushNotificationResponse(int value, String message) {
		this.value = value;
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
