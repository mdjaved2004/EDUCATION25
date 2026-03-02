package com.education25.dao.adminDao.authDao;

import com.education25.model.adminModel.authModel.AdminLoginFormInformationModel;
import com.education25.model.adminModel.authModel.AdminModel;

public interface AdminLoginDao {
    AdminModel checkUserExist(AdminLoginFormInformationModel adminLoginModel);
}