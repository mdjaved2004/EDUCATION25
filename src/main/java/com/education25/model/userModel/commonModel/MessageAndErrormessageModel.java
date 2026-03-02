package com.education25.model.userModel.commonModel;

public class MessageAndErrormessageModel {
	
	private String message;
	private String message_error;
	
	public MessageAndErrormessageModel(String message, String message_error) {
		super();
		this.message = message;
		this.message_error = message_error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}