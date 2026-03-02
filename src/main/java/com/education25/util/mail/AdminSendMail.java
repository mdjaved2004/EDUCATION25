package com.education25.util.mail;

public interface AdminSendMail {
	boolean adminSendMailforInformation(String resis_full_name, String resis_email, int otp);

	boolean adminForgetPassword(String user_name, String user_email, String user_userName, String user_password);	
}