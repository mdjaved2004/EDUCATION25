package com.education25.dao.adminDao.authDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.authModel.AdminLoginFormInformationModel;
import com.education25.model.adminModel.authModel.AdminModel;

public class AdminLoginDaoImpl implements AdminLoginDao {

    @Override
    public AdminModel checkUserExist(AdminLoginFormInformationModel adminLoginModel){
    		AdminModel admin = null;
    			
    		String adminLoginQuery="SELECT a.admin_id, a.admin_userName, a.admin_position, r.name, r.email "
    				+ "FROM admins a JOIN resisters r on a.register_id = r.id "
    				+ "where r.email=? AND a.admin_userName=? AND a.admin_password=?";
        
    		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25();
             PreparedStatement ps = con.prepareStatement(adminLoginQuery)) {

            ps.setString(1, adminLoginModel.getEmail());
            ps.setString(2, adminLoginModel.getLogin_username());
            ps.setString(3, adminLoginModel.getLogin_password());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            		admin = new AdminModel(
            				rs.getInt("admin_id"),
            				rs.getString("name"), 
	                		rs.getString("email"),
	                		rs.getString("admin_userName")
	                		);
            }
            
        }catch(Exception e) {
        		admin=null;
        }
        return admin;
    }
}