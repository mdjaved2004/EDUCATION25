package com.education25.dao.userDao.authDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.authModel.ForgetPasswordModel;
import com.education25.util.mail.UserRegisterSendOtpMail;
import com.education25.util.mail.UserRegisterSendOtpMailImpl;

public class ForgetPasswordDaoImpl implements ForgetPasswordDao {

	@Override
	public ForgetPasswordModel checkAndGetUserInformation(String user_email) {
		ForgetPasswordModel forgetPasswordModel=null;
		try(Connection con = new ConnectionFactoryImpl().getConnForEducation25();
			PreparedStatement ps = con.prepareStatement("SELECT name, userName, password FROM resisters WHERE email = ?")){
		   
			ps.setString(1, user_email);
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        String user_name = rs.getString("name");
		        String user_userName = rs.getString("userName");
				String user_password = rs.getString("password");
				
				forgetPasswordModel = new ForgetPasswordModel(user_name, user_userName, user_password);

		    } else {
		    		forgetPasswordModel=null;
		    } 
		} catch (SQLException e) {
			forgetPasswordModel=null;
		}
		
		return forgetPasswordModel;
	}
	
	@Override
	public String sendMailWithUserNameAndPassword(ForgetPasswordModel forgetPasswordModel, String email) {
		
		try {
			UserRegisterSendOtpMail sendMail=new UserRegisterSendOtpMailImpl();
			
			boolean mailInformationForgetPassword = sendMail.forgetPassWord(forgetPasswordModel.getUser_name(), email, forgetPasswordModel.getUser_username(), forgetPasswordModel.getUser_Password());
			
			if(!mailInformationForgetPassword) {
				return "Process of email sending failed, Please Try again"; 
			}
		} catch (Exception e) {
			return "Process of email sending failed, Please Try again";
		}		
		return null;
	}
}