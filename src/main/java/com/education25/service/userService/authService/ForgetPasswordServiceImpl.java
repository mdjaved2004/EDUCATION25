package com.education25.service.userService.authService;

import com.education25.dao.userDao.authDao.ForgetPasswordDao;
import com.education25.dao.userDao.authDao.ForgetPasswordDaoImpl;
import com.education25.model.userModel.authModel.ForgetPasswordModel;
import com.education25.validation.checkValues.CheckEmaiValidation;

public class ForgetPasswordServiceImpl implements ForgetPasswordService{

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
		
		ForgetPasswordDao forgetPasswordDao = new ForgetPasswordDaoImpl();
		
		//This method to check user exist, if exist then get user information otherwise return error.
		ForgetPasswordModel checkAndGetUserInformation = forgetPasswordDao.checkAndGetUserInformation(email);
		
		if(checkAndGetUserInformation==null) {
			return "This email not register, you are Register first";
		}
		
		//This method to call for sending  email , if any error then return. 
		String sendMailWithUserNameAndPassword = forgetPasswordDao.sendMailWithUserNameAndPassword(checkAndGetUserInformation, email);
		
		if(sendMailWithUserNameAndPassword!=null) {
			return sendMailWithUserNameAndPassword;
		}
				
		return null;
	}
}