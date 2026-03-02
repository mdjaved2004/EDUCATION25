package com.education25.util.mail;

public interface SendMail {
	public boolean sendEmailWithAttachment(String to, String from, String subject, String messageText);
}