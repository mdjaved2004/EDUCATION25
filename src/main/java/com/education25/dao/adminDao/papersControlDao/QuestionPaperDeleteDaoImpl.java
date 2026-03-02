package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperDeleteDaoImpl implements QuestionPaperDeleteDao {

	@Override
	public String deletePaperService(String Paper_name, int adminId) {
		String message_error=null;
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()) {
			 con.setAutoCommit(false);
			 
			//Create new entity and update some entity data. 
			 message_error = deletePaper(con, Paper_name, adminId);
			
			if(message_error!=null) {
				con.rollback();
			}else {
				con.commit();
			}
			
		 }catch(Exception e) {
			 message_error ="Paper deleted failed , Please Try agin";
			 e.printStackTrace();
		 }
		
		return message_error;
	}
	
	private String deletePaper(Connection con, String Paper_name, int adminId) {		
		String paper_name_without_space =null, message_error=null;
		int admin_id_get_Data_base=0, paper_id=0;
		
		paper_name_without_space = new ReplaceSpaceTo_().replaceSpaceTo_(Paper_name);
			
		String check_paper_exists="SELECT paper_id, paper_Name, admin_id FROM  paper_name_all WHERE paper_Name = ? ";
		String update_row_in_paper_name_all_record ="UPDATE paper_name_all SET is_active = FALSE WHERE paper_name = ?";
		
		try (PreparedStatement ps = con.prepareStatement(check_paper_exists);
			 PreparedStatement updateRowPs = con.prepareStatement(update_row_in_paper_name_all_record)) {
			
			ps.setString(1, Paper_name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				admin_id_get_Data_base=rs.getInt("admin_id");
				paper_id =rs.getInt("paper_id");
			}else {
				message_error="This Paper Name Not Availavle, Try Another Paper Name";
			}
			if(message_error==null) {
				if(admin_id_get_Data_base == adminId) {
					updateRowPs.setString(1, Paper_name);
					updateRowPs.executeUpdate();
					
					String update_paper_entity ="ALTER TABLE " + paper_name_without_space +" RENAME TO " + paper_name_without_space + "_" + paper_id + "_" + admin_id_get_Data_base+"";
					try (PreparedStatement update_entityName = con.prepareStatement(update_paper_entity)) {
						update_entityName.executeUpdate();	
					}				
					
				}else {
					message_error="You are not aligible For delete this paper";
				}
			}
				
		}catch(Exception e) {
			 message_error="Failed to delete paper";
			 e.printStackTrace();
		 }
		
		return message_error;	
	}
	private boolean isTableExist(Connection con, String tableName) {
	    if (tableName == null || con == null) return false;
	    try {
	        DatabaseMetaData dbm = con.getMetaData();
	        
	        // MySQL mein table names aksar Case Sensitive hote hain
	        try (ResultSet rs = dbm.getTables(null, null, tableName, new String[] {"TABLE"})) {
	            return rs.next();
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}
}