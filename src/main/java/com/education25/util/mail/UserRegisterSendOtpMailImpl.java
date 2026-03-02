package com.education25.util.mail;

public class UserRegisterSendOtpMailImpl implements UserRegisterSendOtpMail{
	
	@Override
	public boolean  userRegisterSendOtpInMail(String name, String user_email, int otp) {
        String to = user_email;  // Receiver's email
        String from = "mdjavedmansoori22@gmail.com";  // Sender's email
        String subject = "Email with Attachment";
        String messageText = "<html><body>"
                + "<p style='font-size:20px; font-family:Arial, sans-serif; color:#333;'>"
                + "Hello, <b>" + name + "</b>,<br><br>"
                + "Your OTP for verification is: <b style='font-size:22px; color:red;'>" + otp + "</b><br><span style='color:#ff0000; font-weight:bold;'>Please do not share this OTP with anyone.</span><br><br>"
                + "</p></body></html>";
        System.out.println("=========================Task1");
        // This class method to call send OTP in email. 
		boolean sendEmailWithAttachment = new SendMailImpl().sendEmailWithAttachment(to, from, subject, messageText);
		 System.out.println("=========================Task2 :"+ sendEmailWithAttachment);
		return sendEmailWithAttachment;
    }
	
	@Override
	public boolean forgetPassWord(String name, String user_email, String user_name, String user_password) {
        String to = user_email;  // Receiver's email
        String from = "mdjavedmansoori22@gmail.com";  // Sender's email
        String subject = "Email with Attachment";
        String messageText = "<html><body>"
		        + "<p style='font-size:20px; font-family:Arial, sans-serif; color:#333;'>"
		        + "Hello, <b>" + user_name + "</b>,<br>"
		        + "Your user name : <b style='font-size:22px; color:red;'>" + user_name + "</b><br>"
		        + "Your password : <b style='font-size:22px; color:red;'>" + user_password + "</b><br><span style='color:#ff0000; font-weight:bold;'>Please do not share this information anyone.</span>"
		        + "</p></body></html>";

     //Send the email.
       boolean sendEmailWithAttachment = new SendMailImpl().sendEmailWithAttachment(to, from, subject, messageText);
       
       return sendEmailWithAttachment;
    }
}