package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperDeleteOneQuetionDaoImpl implements QuestionPaperDeleteOneQuetionDao {

	@Override
	public String deleteOneQuestionDao(String paper_name, String questionNo) {
		String message_error=null;
		 
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()){
			con.setAutoCommit(false);
			
			message_error = deteteQuestion(con, paper_name, questionNo);
			
			if(message_error!=null) {
				con.rollback();
			}else {
				con.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			message_error = "Failed to delete question, Please try again.";
		}	
		return message_error;
	}
	
	String deteteQuestion(Connection con, String paper_name, String questionNo) {
		String message_error=null, paper_name_without_space=null, optionMarks=null, notOptionMarks=null, upadatePaperInfoQuery=null;	
		int question_no = 0;
		
		paper_name_without_space=new ReplaceSpaceTo_().replaceSpaceTo_(paper_name);
		question_no = Integer.parseInt(questionNo);
		
		String getSomeInfo="SELECT optionMarks, notOptionMarks FROM "+paper_name_without_space+" WHERE ques_id = ? ";					
		String column_modify_notprimary = "ALTER TABLE " + paper_name_without_space + " DROP PRIMARY KEY"; 	
		String one_question_delete ="DELETE FROM "+paper_name_without_space+" WHERE ques_id = ? ";
		String rearrange_paper_ques_id = "UPDATE " + paper_name_without_space + " SET ques_id = ques_id - 1 WHERE ques_id > ?";	
		String apply_primary_key="ALTER TABLE "+ paper_name_without_space +" ADD PRIMARY KEY (ques_id)";		

		try{
			PreparedStatement ps = con.prepareStatement(getSomeInfo);
			ps.setInt(1, question_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				optionMarks = rs.getString("optionMarks");
				notOptionMarks = rs.getString("notOptionMarks");
			}
			if(optionMarks!=null && notOptionMarks!=null) {
				ps = con.prepareStatement(column_modify_notprimary);		
				ps.execute();
				
				ps = con.prepareStatement(one_question_delete);
				ps.setInt(1, question_no);
				ps.executeUpdate();
				
				ps = con.prepareStatement(rearrange_paper_ques_id);		
				ps.setInt(1, question_no);
				ps.executeUpdate();
								
				ps = con.prepareStatement(apply_primary_key);		
				ps.execute();
				
				if(optionMarks.equals("0")) {
				    upadatePaperInfoQuery = "UPDATE paper_name_all SET total_ques = total_ques - 1, notOption_ques = notOption_ques - 1 WHERE paper_Name = ?";
				} else {
				    upadatePaperInfoQuery = "UPDATE paper_name_all SET total_ques = total_ques - 1, option_ques = option_ques - 1 WHERE paper_Name = ?";
				}
				ps = con.prepareStatement(upadatePaperInfoQuery);
				ps.setString(1, paper_name);
				ps.executeUpdate();
			}					
		}catch(Exception e) {
			e.printStackTrace();
			message_error = "Failed to delete question, Please try again.";
		}
		return message_error;
	}
}