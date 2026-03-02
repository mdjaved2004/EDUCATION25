package com.education25.service.adminService.authService;

import com.education25.dao.adminDao.authDao.ForgetPasswordAdminDao;
import com.education25.dao.adminDao.authDao.ForgetPasswordAdminDaoImpl;
import com.education25.model.adminModel.authModel.ForgetPasswordAdminModel;
import com.education25.validation.checkValues.CheckEmaiValidation;

public class ForgetPasswordAdminServiceImpl implements ForgetPasswordAdminService{

	@Override
	public String checkValidation(String email) {
		
		//Email Validation
	    if (email.length() > 35 || !new CheckEmaiValidation().emailValidation(email)) {
	    		return "Invalid Email. enter a valid email format and under 36 characters.";        
	    }
		return null;
	}

	@Override
	public String forgetPasswordSendMail(String email) {
		
		ForgetPasswordAdminDao forgetPasswordAdminDao = new ForgetPasswordAdminDaoImpl();
		
		//This method to check user exist, if exist then get user information otherwise return error.
		ForgetPasswordAdminModel checkAndGetUserInformation =forgetPasswordAdminDao.checkAndGetUserInformation(email);
		
		if(checkAndGetUserInformation==null) {
			return "This email not register, you are Register first";
		}
		
		//This method to call for sending  email , if any error then return. 
		String sendMailWithUserNameAndPassword = forgetPasswordAdminDao.sendMailWithUserNameAndPassword(checkAndGetUserInformation, email);
		
		if(sendMailWithUserNameAndPassword!=null) {
			return sendMailWithUserNameAndPassword;
		}
					
		return null;
	}
}