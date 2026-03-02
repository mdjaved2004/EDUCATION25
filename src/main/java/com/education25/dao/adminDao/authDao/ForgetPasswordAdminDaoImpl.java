package com.education25.dao.adminDao.authDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.authModel.ForgetPasswordAdminModel;
import com.education25.util.mail.AdminSendMail;
import com.education25.util.mail.AdminSendMailImpl;

public class ForgetPasswordAdminDaoImpl implements ForgetPasswordAdminDao {

	@Override
	public ForgetPasswordAdminModel checkAndGetUserInformation(String user_email) {
		ForgetPasswordAdminModel forgetPasswordAdminModel=null;
		String forgetPasswordQuery="SELECT name r, admin_userName a, admin_password a FROM resisters r JOIN admins ON r.id = a.admin_id WHERE r.email = ?";
		try(Connection con = new ConnectionFactoryImpl().getConnForEducation25();
			PreparedStatement ps = con.prepareStatement(forgetPasswordQuery)){
			ps.setString(1, user_email);
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        String admin_name = rs.getString("name");
		        String admin_userName = rs.getString("admin_userName");
				String admin_password = rs.getString("admin_password");
				
				forgetPasswordAdminModel = new ForgetPasswordAdminModel(admin_name, admin_userName, admin_password);
		    } else {
		    		forgetPasswordAdminModel=null;
		    } 
		} catch (SQLException e) {
			forgetPasswordAdminModel=null;
		}

		return forgetPasswordAdminModel;
	}
	
	@Override
	public String sendMailWithUserNameAndPassword(ForgetPasswordAdminModel forgetPasswordAdminModel, String email) {
		
		try {
			AdminSendMail sendMail=new AdminSendMailImpl();
			
			boolean mailInformationForgetPassword = sendMail.adminForgetPassword(forgetPasswordAdminModel.getAdmin_name(), email, forgetPasswordAdminModel.getAdmin_username(), forgetPasswordAdminModel.getAdmin_Password());
			
			if(!mailInformationForgetPassword) {
				return "Process of email sending failed, Please Try again"; 
			}
		} catch (Exception e) {
			return "Process of email sending failed, Please Try again";
		}
		
		return null;
	}
}