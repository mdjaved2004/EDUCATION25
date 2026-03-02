package com.education25.model.userModel.authModel;

public class RegisterReturnModel {
	
	private int userId;
	private String messageError;
	
	public RegisterReturnModel(int userId, String messageError) {
		super();
		this.userId = userId;
		this.messageError = messageError;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}	
}