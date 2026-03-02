package com.education25.service.adminService.authService;

import com.education25.model.adminModel.authModel.AdminLoginFormInformationModel;
import com.education25.model.adminModel.authModel.AdminModel;

public interface AdminLoginService {
	
	//login existing user based on login form information..
	AdminModel loginService(AdminLoginFormInformationModel adminLoginModel);
	
	//check input validation
    String checkValidation(AdminLoginFormInformationModel adminLoginModel);
}