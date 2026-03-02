package com.education25.service.adminService.authService;

import com.education25.dao.adminDao.authDao.AdminLoginDaoImpl;
import com.education25.model.adminModel.authModel.AdminLoginFormInformationModel;
import com.education25.model.adminModel.authModel.AdminModel;
import com.education25.validation.checkValues.CheckEmaiValidation;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithoutSpace;

public class AdminLoginServiceImpl implements AdminLoginService {

    @Override
    public AdminModel loginService(AdminLoginFormInformationModel adminLoginModel) {
        try {
        		return new AdminLoginDaoImpl().checkUserExist(adminLoginModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String checkValidation(AdminLoginFormInformationModel adminLoginModel) {
    	String message_error = null, email=null, username=null, password=null;
    	
    	CheckStringLetterOrDigitWithoutSpace check = new CheckStringLetterOrDigitWithoutSpace();
    	
    	email = adminLoginModel.getEmail();
    	username = adminLoginModel.getLogin_username();
    	password = adminLoginModel.getLogin_password();
    	
    	if (username.length() > 30 || !check.checkStringLetterOrDigit(username)) {
    		message_error = "Username should have only A-Z, a-z, 0-9 and less than 31 characters.";
    		return message_error;
    	}
    	
    	if (password.length() > 30 || !check.checkStringLetterOrDigit(password)) {
    		message_error = "Password should have only A-Z, a-z, 0-9 and less than 31 characters.";
    		return message_error;
    	}
    	
    	if (email.length() > 35 || !new CheckEmaiValidation().emailValidation(email)) {
    		message_error = "Invalid Email. enter a valid email format and under 36 characters.";
        return message_error;
    }
    	
    	return null;
    }  
}