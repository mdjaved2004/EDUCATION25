package com.education25.dao.userDao.authDao;

import java.sql.*;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.authModel.UserModel;

public class LoginDaoImpl implements LoginDao {

    @Override
    public UserModel checkUserExist(String username, String password){
        
    		UserModel user = null;

        try (Connection con = new ConnectionFactoryImpl().getConnForEducation25();
             PreparedStatement ps = con.prepareStatement("SELECT id, name, email, userName FROM resisters WHERE userName = ? AND password = ?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel(rs.getInt("id"), rs.getString("name"), 
                		rs.getString("email"), rs.getString("userName"));
            }
            
        }catch(Exception e) {
        		user=null;
        }
        return user;
    }
}