package com.education25.dao.userDao.authDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.model.userModel.authModel.RegisterReturnModel;

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public String userExist(Connection con, String email, String userName) {
		String messageError=null;
		
		try {
			// Check email or userName exist or not
			String checkSQL = "SELECT email, userName FROM resisters WHERE email = ? OR userName = ?";
			
			PreparedStatement psCheck = con.prepareStatement(checkSQL);
			psCheck.setString(1, email);
			psCheck.setString(2, userName);
			ResultSet rs = psCheck.executeQuery();

			if (rs.next()) {
			    if (rs.getString("email").equals(email)) {
			    	messageError ="This email is already registered.";  	
			    }

			    if (rs.getString("userName").equals(userName)) {
			    	messageError ="Enter Strong UserName.";
			    }
			}
		} catch (SQLException e) {
			
		}
		return messageError;
	}

	@Override
	public RegisterReturnModel saveUser(RegisterFormInformationModel registerFormModel) {

	    Connection con = null;
	    String messageError = null;

	    try {

	        con = new ConnectionFactoryImpl().getConnForEducation25();
	        con.setAutoCommit(false);   // Start transaction

	        // 1. Check duplicate user
	        String userExistMessage = userExist(con, registerFormModel.getEmail(), registerFormModel.getUserName());

	        if (userExistMessage != null) {
	            con.commit();
	            return new RegisterReturnModel(0, userExistMessage);
	        }

	        // 2. Insert User
	        String insertSQL = "INSERT INTO resisters(name, email, userName, password) VALUES (?, ?, ?, ?)";
	        PreparedStatement psInsert = con.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);

	        psInsert.setString(1, registerFormModel.getFullName());
	        psInsert.setString(2, registerFormModel.getEmail());
	        psInsert.setString(3, registerFormModel.getUserName());
	        psInsert.setString(4, registerFormModel.getPassword());

	        int rows = psInsert.executeUpdate();

	        if (rows > 0) {

	            // 3. Get generated user id
	            int generatedKey = 0;
	            ResultSet generatedKeys = psInsert.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                generatedKey = generatedKeys.getInt(1);
	            }

	            con.commit();   // Success
	            return new RegisterReturnModel(generatedKey, null);
	        } 
	        else {
	            con.rollback();
	            messageError = "Registration failed. Please try again.";
	        }

	    } catch (Exception e) {

	        try { 
	            if (con != null) con.rollback();
	        } catch (Exception ex) {}

	        messageError = "Registration failed. Please try again.";

	    } finally {

	        try { 
	            if (con != null) con.close();
	        } catch (Exception ex) {}

	    }
	    return new RegisterReturnModel(0, messageError);
	}
}