package com.education25.service.userService.authService;

import com.education25.model.userModel.authModel.LoginFormInformationModel;
import com.education25.model.userModel.authModel.UserModel;

public interface LoginService {
	
	//login existing user based on login form information..
	UserModel loginService(LoginFormInformationModel loginModel);
	
	//check input validation
    String checkValidation(LoginFormInformationModel loginModel);
}