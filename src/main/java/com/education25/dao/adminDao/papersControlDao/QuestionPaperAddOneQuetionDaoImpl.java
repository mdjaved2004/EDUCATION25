package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperAddOneQuetionDaoImpl implements QuestionPaperAddOneQuetionDao{
	
	@Override
	public String addOneQuestionDao(QuestionPaperQuestionDataModel questionInformationModel, String paper_name) {
		String message_error=null;
		 
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()){
			con.setAutoCommit(false);
			
			message_error = addNewQuestionAndUpdatPaperRecord(con, questionInformationModel, paper_name);
			
			if(message_error!=null) {
				con.rollback();
			}else {
				con.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			message_error = "Failed to add question,Please try again.";
		}	
		return message_error;
	}
	
	String addNewQuestionAndUpdatPaperRecord(Connection con, QuestionPaperQuestionDataModel questionInformationModel, String paper_name) {
		String message_error=null, paper_name_without_space=null, optionMarks=null, notOptionMarks=null, upadatePaperInfoQuery=null;	
		int question_no = 0, question_no_temp=0;
		
		paper_name_without_space=new ReplaceSpaceTo_().replaceSpaceTo_(paper_name);
		question_no = questionInformationModel.getQuestion_no();
		
		if(question_no==1) {
			question_no_temp=question_no;
		}else {
			question_no_temp=question_no-1;
		}
		
		String getSomeInfo="SELECT optionMarks, notOptionMarks FROM "+paper_name_without_space+" WHERE ques_id = ? ";					
		String column_modify_notprimary = "ALTER TABLE " + paper_name_without_space + " DROP PRIMARY KEY"; 	
		String apply_primary_key="ALTER TABLE "+ paper_name_without_space +" ADD PRIMARY KEY (ques_id)";		
		String rearrange_paper_ques_id = "UPDATE " + paper_name_without_space + " SET ques_id = ques_id + 1 WHERE ques_id >= ?";	
		String one_question_add = "INSERT INTO " + paper_name_without_space + "(ques_id, question, option_A, option_B, option_C, option_D, ans_op, optionMarks, notOptionMarks)"
		    + " VALUES(?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement ps = con.prepareStatement(getSomeInfo);
			ps.setInt(1, question_no_temp);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				optionMarks = rs.getString("optionMarks");
				notOptionMarks = rs.getString("notOptionMarks");
			}
			if(optionMarks!=null && notOptionMarks!=null) {
				ps = con.prepareStatement(column_modify_notprimary);		
				ps.execute();
				
				ps = con.prepareStatement(rearrange_paper_ques_id);		
				ps.setInt(1, question_no);
				ps.executeUpdate();
				
				ps = con.prepareStatement(one_question_add);
				ps.setInt(1, question_no);
				ps.setString(2, questionInformationModel.getQuestion());
				ps.setString(3, questionInformationModel.getOption_a());
				ps.setString(4, questionInformationModel.getOption_b());
				ps.setString(5, questionInformationModel.getOption_c());
				ps.setString(6, questionInformationModel.getOption_d());
				ps.setString(7, questionInformationModel.getAnswer());			
				ps.setString(8, optionMarks);
				ps.setString(9, notOptionMarks);
				ps.executeUpdate();
				
				ps = con.prepareStatement(apply_primary_key);		
				ps.execute();
				
				if(optionMarks.equals("0")) {
				    upadatePaperInfoQuery = "UPDATE paper_name_all SET total_ques = total_ques + 1, notOption_ques = notOption_ques + 1 WHERE paper_Name = ?";
				} else {
				    upadatePaperInfoQuery = "UPDATE paper_name_all SET total_ques = total_ques + 1, option_ques = option_ques + 1 WHERE paper_Name = ?";
				}
				ps = con.prepareStatement(upadatePaperInfoQuery);
				ps.setString(1, paper_name);
				ps.executeUpdate();
			}					
		}catch(Exception e) {
			e.printStackTrace();
			message_error = "Failed to add question,Please try again.";
		}
		return message_error;
	}
}