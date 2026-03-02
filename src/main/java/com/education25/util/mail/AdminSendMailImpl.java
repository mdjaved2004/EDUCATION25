package com.education25.util.mail;

public class AdminSendMailImpl implements AdminSendMail {

	@Override
	public boolean adminSendMailforInformation(String resis_full_name, String resis_email, int otp) {
	
		String to = resis_email;  // Receiver's email
        String from = "mdjavedmansoori22@gmail.com";  // Sender's email
        String subject = "Email with Attachment";
        String messageText = "<html><body>"
                + "<p style='font-size:20px; font-family:Arial, sans-serif; color:#333;'>"
                + "Hello, <b>" + resis_full_name + "</b>,<br><br>"
                + "Your OTP for verification is: <b style='font-size:22px; color:red;'>" + otp + "</b><br><span style='color:#ff0000; font-weight:bold;'>Please do not share this OTP with anyone.</span><br><br>"
                + "</p></body></html>";
        
        // This class method to call send OTP in email. 			
		boolean sendEmailWithAttachment = new SendMailImpl().sendEmailWithAttachment(to, from, subject, messageText);
		return sendEmailWithAttachment;
	}

	@Override
	public boolean adminForgetPassword(String admin_name, String admin_email, String admin_userName, String admin_password) {
		String to = admin_email;  // Receiver's email
		String from = "mdjavedmansoori22@gmail.com";  // Sender's email
		String subject = "Email with Attachment";
		String messageText = "<html><body>"
		        + "<p style='font-size:20px; font-family:Arial, sans-serif; color:#333;'>"
		        + "Hello, <b>" + admin_name + "</b>,<br>"
		        + "Your user name : <b style='font-size:22px; color:red;'>" + admin_userName + "</b><br>"
		        + "Your password : <b style='font-size:22px; color:red;'>" + admin_password + "</b><br><span style='color:#ff0000; font-weight:bold;'>Please do not share this information anyone.</span>"
		        + "</p></body></html>";

        // This class method to call send OTP in email. 			
		boolean sendEmailWithAttachment = new SendMailImpl().sendEmailWithAttachment(to, from, subject, messageText);
		return sendEmailWithAttachment;
	}
}