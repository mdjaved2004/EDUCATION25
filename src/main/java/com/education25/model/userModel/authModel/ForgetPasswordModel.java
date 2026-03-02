package com.education25.model.userModel.authModel;

public class ForgetPasswordModel {
	
	private String user_name;
    private String user_username;
    private String user_Password;
	
    public ForgetPasswordModel(String user_name, String user_username, String user_Password) {
		super();
		this.user_name = user_name;
		this.user_username = user_username;
		this.user_Password = user_Password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_Password() {
		return user_Password;
	}

	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}   
}