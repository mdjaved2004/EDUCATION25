package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperInformationModel;
import com.education25.model.adminModel.paperControlModel.QuetionPaperFullInformationWithMessageErrorModel;
import com.education25.model.adminModel.paperControlModel.QuetionPaperQuetionInformationGetModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperQuestionDataGetDaoImpl implements QuestionPaperQuestionDataGetDao {

	@Override
	public QuetionPaperFullInformationWithMessageErrorModel getInforDao(String paper_name) {
		String message_error=null;
		QuestionPaperInformationModel paperInformation=null;
		List<QuetionPaperQuetionInformationGetModel> questionInfoList=null;

		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();){
			con.setAutoCommit(false);
			paperInformation= getPaperInformation(paper_name, con);
			
			questionInfoList = getQuestionInformation(paper_name, con);
			con.commit();
			if(paperInformation==null) {
				message_error = "This Paper Name Not availablr , try agin to another paper Name";
			}
		}catch(Exception e) {
			message_error = "Failed to get Data, try again";
		}
		
		return new QuetionPaperFullInformationWithMessageErrorModel(paperInformation, questionInfoList, message_error);
	}
		
	QuestionPaperInformationModel getPaperInformation(String Paper_name, Connection con) {
		QuestionPaperInformationModel paperInformation=null;
		String queryPaperInfo="SELECT paper_Name, total_ques, option_ques, notOption_ques FROM paper_name_all WHERE paper_Name = ?";
				
			
		try(PreparedStatement ps=con.prepareStatement(queryPaperInfo)) {
			ps.setString(1, Paper_name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				paperInformation= new QuestionPaperInformationModel(rs.getString("paper_Name"), rs.getString("total_ques"), rs.getString("option_ques"), rs.getString("notOption_ques"));
			}
		}catch(Exception e) {
			paperInformation =null;
		}
		return paperInformation;
	}
	
	List<QuetionPaperQuetionInformationGetModel> getQuestionInformation(String Paper_name, Connection con) {
		List<QuetionPaperQuetionInformationGetModel> questionInfoList =new ArrayList<QuetionPaperQuetionInformationGetModel>();
		Paper_name = new ReplaceSpaceTo_().replaceSpaceTo_(Paper_name);
		
		String queryQuestionInfo="SELECT * FROM "+Paper_name+" ";
		
		try(PreparedStatement ps=con.prepareStatement(queryQuestionInfo)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				questionInfoList.add(new QuetionPaperQuetionInformationGetModel(
						rs.getInt("ques_id"),
						rs.getString("question"),
						rs.getString("option_A"),
						rs.getString("option_B"),
						rs.getString("option_c"),
						rs.getString("option_D"),
						rs.getString("ans_op"),
						rs.getString("optionMarks"),
						rs.getString("notOptionMarks")
						));				
			}
		}catch(Exception e) {
			questionInfoList =null;
		}
		return questionInfoList;
	}
}
