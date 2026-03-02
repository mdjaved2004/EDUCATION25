package com.education25.model.userModel.authModel;

public class RegisterFormInformationModel {

    private String fullName;
    private String email;
    private String userName;
    private String password;
    private String confirmPassword;

    public RegisterFormInformationModel(String fullName, String email, String userName, String password,
			String confirmPassword) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}