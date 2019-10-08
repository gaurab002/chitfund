package com.chitfund.pushnotification;

public class PushNotificationRequest {

	String title, message, topic;

	public PushNotificationRequest(String title, String message, String topic) {
		this.title = title;
		this.message = message;
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	

}
