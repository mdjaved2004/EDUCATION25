package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;

public class QuestionPaperTempletCheckDaoImpl implements QuestionPaperTempletCheckDao {
	@Override
	public QuestionPaperTempletCheckModel checkInformationDao(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
			PreparedStatement ps = con.prepareStatement("SELECT paper_Name FROM paper_name_all WHERE paper_Name = ?");){
			
			ps.setString(1, quesPaperbasicInfoFormModel.getPaper_name());
			ResultSet rs = ps.executeQuery();		
			
			if(rs.next()) {
				message_error = "This paper Name already exist, Please change paper name";
			}
		}catch(Exception e) {
			message_error = "Failed validation try again";
		}
		if(message_error!=null) {
			quesPaperbasicInfoFormModel.setMessage_error(message_error);
		}
		
		return quesPaperbasicInfoFormModel;
	}
}