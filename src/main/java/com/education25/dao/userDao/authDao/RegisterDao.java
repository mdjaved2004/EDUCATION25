package com.education25.dao.userDao.authDao;

import java.sql.Connection;
import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.model.userModel.authModel.RegisterReturnModel;

public interface RegisterDao {

    // Check user exist or not based on email and userName;
	String userExist(Connection con, String email, String userName);

    // Save user into database
	RegisterReturnModel saveUser(RegisterFormInformationModel registerFormModel);
}