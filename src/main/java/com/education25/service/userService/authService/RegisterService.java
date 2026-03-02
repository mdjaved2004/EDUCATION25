package com.education25.service.userService.authService;

import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.model.userModel.authModel.RegisterReturnModel;

public interface RegisterService {
	
	//Registers a new user based on the register details.
	RegisterReturnModel registerService(RegisterFormInformationModel registerFormModel);
  
	//check input validation
	String checkValidation(RegisterFormInformationModel registerFormModel);
}