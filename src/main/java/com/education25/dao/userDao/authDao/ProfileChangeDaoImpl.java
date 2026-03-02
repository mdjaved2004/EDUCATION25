package com.education25.dao.userDao.authDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class ProfileChangeDaoImpl implements ProfileChangeDao {

	@Override
	public String updateProfileDao(int user_id, String name, String userName) {
		String message_error =null;
		
		String updateQuery="UPDATE resisters SET name = ?, userName = ? WHERE id = ? ";
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25();
	           PreparedStatement ps = con.prepareStatement(updateQuery)) {

	            ps.setString(1, name);
	            ps.setString(2, userName);
	            ps.setInt(3, user_id);

	            int rs = ps.executeUpdate();
	            if(rs<=0) {
	            		message_error ="Failed to update profile";
	            }    
	        }catch(Exception e) {
	        		message_error ="Server Error, Please try again";
	        }
	        return message_error;
	}
}