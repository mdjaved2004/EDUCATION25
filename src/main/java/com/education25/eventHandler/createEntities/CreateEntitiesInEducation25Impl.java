package com.education25.eventHandler.createEntities;

import java.sql.Connection;
import com.education25.dao.connections.ConnectionFactoryImpl;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
public class CreateEntitiesInEducation25Impl {

    public boolean createEntitiesInEducation25() {

	    	String createResistersEntity =
	    		    "CREATE TABLE IF NOT EXISTS resisters ("
	    		    + "id INT AUTO_INCREMENT PRIMARY KEY, "
	    		    + "name VARCHAR(40), "
	    		    + "email VARCHAR(40), "
	    		    + "userName VARCHAR(30), "
	    		    + "password VARCHAR(30))";

        String createAdminsEntity =
                "CREATE TABLE IF NOT EXISTS admins ("
                + "admin_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "admin_userName VARCHAR(40) DEFAULT NULL, "
                + "admin_password VARCHAR(40) DEFAULT NULL, "
                + "admin_position SMALLINT NOT NULL, "
                + "register_id INT DEFAULT NULL, "
                + "KEY register_id (register_id), "
                + "FOREIGN KEY (register_id) REFERENCES resisters(id)"
                + ")";
        try (Connection con = new ConnectionFactoryImpl().getConnForEducation25();
             Statement stmt = con.createStatement()) {
        	
            con.setAutoCommit(false);
            // Create Tables
            stmt.execute(createResistersEntity);
            stmt.execute(createAdminsEntity);
            // Check if resisters table empty
            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM resisters");
            rs1.next();
            if (rs1.getInt(1) == 0) {
                PreparedStatement ps1 = con.prepareStatement("INSERT INTO resisters (name, email, userName, password) VALUES (?, ?, ?, ?)");
                ps1.setString(1, System.getenv("ADMIN_NAME"));
                ps1.setString(2, System.getenv("ADMIN_EMAIL"));
                ps1.setString(3, System.getenv("user_user_name"));
                ps1.setString(4, System.getenv("user_password"));
                ps1.executeUpdate();
                ps1.close();
            }

            // Check if admins table empty
            ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM admins");
            rs2.next();
            if (rs2.getInt(1) == 0) {
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO admins (admin_userName, admin_password, admin_position, register_id) VALUES (?, ?, ?, ?)");
                ps2.setString(1, System.getenv("ADMIN_USER_NAME"));
                ps2.setString(2, System.getenv("ADMIN_PASSWORD"));
                ps2.setInt(3, Integer.parseInt(System.getenv("ADMIN_POSITION")));
                ps2.setInt(4, 1);
                ps2.executeUpdate();
                ps2.close();
            }

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
