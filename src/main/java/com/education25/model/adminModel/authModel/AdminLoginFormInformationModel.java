package com.education25.model.adminModel.authModel;

public class AdminLoginFormInformationModel {
	
	private String email;
    private String login_username;
    private String login_password;
	
    public AdminLoginFormInformationModel(String email, String login_username, String login_password) {
		super();
		this.email = email;
		this.login_username = login_username;
		this.login_password = login_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin_username() {
		return login_username;
	}

	public void setLogin_username(String login_username) {
		this.login_username = login_username;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}     
}
