package com.education25.dao.userDao.authDao;

import com.education25.model.userModel.authModel.ForgetPasswordModel;

public interface ForgetPasswordDao {	
	
	//Check and Get user information based on email
	ForgetPasswordModel checkAndGetUserInformation(String user_email);
	
	//if user exist then send mail with userName and Password
	String sendMailWithUserNameAndPassword(ForgetPasswordModel forgetPasswordModel, String email);
}