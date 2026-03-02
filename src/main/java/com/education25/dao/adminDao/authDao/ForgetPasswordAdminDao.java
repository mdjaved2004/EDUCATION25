package com.education25.dao.adminDao.authDao;

import com.education25.model.adminModel.authModel.ForgetPasswordAdminModel;

public interface ForgetPasswordAdminDao {	
	
	//Check and Get user information based on email
	ForgetPasswordAdminModel checkAndGetUserInformation(String user_email);
	
	//if user exist then send mail with userName and Password
	String sendMailWithUserNameAndPassword(ForgetPasswordAdminModel forgetPasswordModel, String email);
}