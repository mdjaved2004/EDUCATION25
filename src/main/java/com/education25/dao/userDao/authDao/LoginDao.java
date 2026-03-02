package com.education25.dao.userDao.authDao;

import com.education25.model.userModel.authModel.UserModel;

public interface LoginDao {
    UserModel checkUserExist(String username, String password);
}