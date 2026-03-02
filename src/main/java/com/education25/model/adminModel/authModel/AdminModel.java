package com.education25.model.adminModel.authModel;

public class AdminModel {
    private int admin_id;
    private String admin_name;
    private String admin_email;
    private String admin_username;
	
    public AdminModel(int admin_id, String admin_name, String admin_email, String admin_username) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_username = admin_username;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

}
