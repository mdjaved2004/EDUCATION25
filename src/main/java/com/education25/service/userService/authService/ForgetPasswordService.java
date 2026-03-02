package com.education25.service.userService.authService;

public interface ForgetPasswordService {
	
	//check input validation
	String checkValidation(String email);
	
	//Send password and userName through email
	String forgetPasswordSendMail(String email);
}