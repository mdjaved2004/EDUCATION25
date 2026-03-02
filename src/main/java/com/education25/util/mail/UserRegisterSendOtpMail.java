package com.education25.util.mail;

public interface UserRegisterSendOtpMail {
	public boolean  userRegisterSendOtpInMail(String name, String user_email, int otp);
	public boolean forgetPassWord(String name, String user_email, String user_name, String user_password);
}