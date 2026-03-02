package com.education25.model.adminModel.authModel;

public class ForgetPasswordAdminModel {
	
	private String admin_name;
    private String admin_username;
    private String admin_Password;
	
    public ForgetPasswordAdminModel(String admin_name, String admin_username, String admin_Password) {
		super();
		this.admin_name = admin_name;
		this.admin_username = admin_username;
		this.admin_Password = admin_Password;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_Password() {
		return admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}    
}