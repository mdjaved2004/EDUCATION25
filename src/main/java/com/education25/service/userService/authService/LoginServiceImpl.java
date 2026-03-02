package com.education25.service.userService.authService;

import com.education25.dao.userDao.authDao.LoginDaoImpl;
import com.education25.model.userModel.authModel.LoginFormInformationModel;
import com.education25.model.userModel.authModel.UserModel;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithoutSpace;

public class LoginServiceImpl implements LoginService {

    @Override
    public UserModel loginService(LoginFormInformationModel loginModel) {
        try {
        		return new LoginDaoImpl().checkUserExist(loginModel.getLogin_username(), loginModel.getLogin_password());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String checkValidation(LoginFormInformationModel loginModel) {
    	String message_error = null;
    	
    	CheckStringLetterOrDigitWithoutSpace check = new CheckStringLetterOrDigitWithoutSpace();
    	
    	String username = loginModel.getLogin_username();
    	String password = loginModel.getLogin_password();
    	
    	if (!check.checkStringLetterOrDigit(username) || username.length() > 30) {
    		message_error = "Username should have only A-Z, a-z, 0-9 and less than 31 characters.";
    		return message_error;
    	}
    	
    	if (!check.checkStringLetterOrDigit(password) || password.length() > 30) {
    		message_error = "Password should have only A-Z, a-z, 0-9 and less than 31 characters.";
    		return message_error;
    	}
    	
    	return null;
    } 
}