package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class QuestionPaperUpdateFormCheckDaoImpl implements QuestionPaperUpdateFormCheckDao {

	@Override
	public String CheckAndGetInformationDao(int admin_id, String paper_name) {
		String message_error =null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
			PreparedStatement ps = con.prepareStatement("SELECT paper_Name FROM paper_name_all WHERE paper_Name = ?");){
			
			ps.setString(1, paper_name);
			ResultSet rs = ps.executeQuery();		
			
			if(rs.next()) {
				message_error = null;
			}else {
				message_error = "This paper Name Not exist, Please try agin";
			}
		}catch(Exception e) {
			message_error = "Failed validation try again";
		}
		
		return message_error;
	}
}