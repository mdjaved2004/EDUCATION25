package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.PaperInformationForImageUpdateModel;

public class QuestionPaperUpdateImageViewDaoImpl implements QuestionPaperUpdateImageViewDao {

	@Override
	public PaperInformationForImageUpdateModel getPaperInfoDao(String paper_name) {
		String message_error =null;
		PaperInformationForImageUpdateModel paperInfo =null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
			PreparedStatement ps = con.prepareStatement("SELECT paper_id, paper_Name, total_ques, image_link FROM paper_name_all WHERE paper_Name = ?");){
			
			ps.setString(1, paper_name);
			ResultSet rs = ps.executeQuery();		
			if(rs.next()) {
				paperInfo = new PaperInformationForImageUpdateModel(rs.getInt("paper_id"), rs.getString("paper_Name"), rs.getInt("total_ques"), rs.getString("image_link"), message_error);
			}else {
				message_error = "This paper Name Not exist, Please try agin";
			}
		}catch(Exception e) {
			message_error = "Failed, try again";
		}
		if(message_error!=null) {
			paperInfo = new PaperInformationForImageUpdateModel(0, null, 0, null, message_error);
		}
		return paperInfo;
	}
}