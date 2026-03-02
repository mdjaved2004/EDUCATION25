package com.education25.service.adminService.authService;


public interface ForgetPasswordAdminService {
	
	//check input validation
	String checkValidation(String email);
	
	//Send password and userName through email
	String forgetPasswordSendMail(String email);
}