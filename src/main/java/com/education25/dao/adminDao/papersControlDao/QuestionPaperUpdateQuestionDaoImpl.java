package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperUpdateQuestionDaoImpl implements QuestionPaperUpdateQuestionDao {

	@Override
	public String updateQuestionDao(QuestionPaperQuestionDataModel questionInformationModel, String paper_name) {
		String message_error=null, paper_name_without_space=null;
		paper_name_without_space=new ReplaceSpaceTo_().replaceSpaceTo_(paper_name);
		 
		String updateQuestionQuery = "UPDATE "+paper_name_without_space+ " SET question=?, option_A=?, option_B=?, option_C=?, option_D=?, ans_op=? WHERE ques_id=?";


		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
			PreparedStatement ps = con.prepareStatement(updateQuestionQuery)){
			con.setAutoCommit(false);
			
			ps.setString(1, questionInformationModel.getQuestion());
			ps.setString(2, questionInformationModel.getOption_a());
			ps.setString(3, questionInformationModel.getOption_b());
			ps.setString(4, questionInformationModel.getOption_c());
			ps.setString(5, questionInformationModel.getOption_d());
			ps.setString(6, questionInformationModel.getAnswer());
			ps.setInt(7, questionInformationModel.getQuestion_no());
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate>0) {
				con.commit();
			}else {
				con.rollback();
				message_error = "Question Updated Failed ,Please try.";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			message_error = "Question Updated Failed ,Please try again.";
		}
		
		return message_error;
	}
}