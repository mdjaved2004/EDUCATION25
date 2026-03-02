package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class QuestionPaperInsertDaoImpl implements QuestionPaperInsertDao{

	@Override
	public String questionPaperInsertDao(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel,
			List<QuestionPaperQuestionDataModel> questionDataStrore, int adminId) {
			String message_error=null;
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()) {
			 con.setAutoCommit(false);
			 
			//Create new entity and update some entity data. 
			 message_error = CreateNewEntitiAndinsertData(quesPaperbasicInfoFormModel, questionDataStrore, con, adminId);
			
			if(message_error!=null) {
				con.rollback();
			}else {
				con.commit();			}
			
		 }catch(Exception e) {
			 message_error ="Data inserted failed , Please Try agin";
			 e.printStackTrace();
		 }
		
		return message_error;
	}
	
	String CreateNewEntitiAndinsertData(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel, List<QuestionPaperQuestionDataModel> questionDataStrore, Connection con, int adminId){
		String paper_name=null, select_marks=null, notSelect_marks=null, message_error=null;
		int total_ques=0, select_ques=0,  notSelect_ques=0;
		
		paper_name =new ReplaceSpaceTo_().replaceSpaceTo_(quesPaperbasicInfoFormModel.getPaper_name());
		total_ques = Integer.parseInt(quesPaperbasicInfoFormModel.getTotal_ques());
		select_ques = Integer.parseInt(quesPaperbasicInfoFormModel.getSelect_que());
		select_marks = quesPaperbasicInfoFormModel.getSelect_marks();
		notSelect_ques = Integer.parseInt(quesPaperbasicInfoFormModel.getNotSelect_que());
		notSelect_marks = quesPaperbasicInfoFormModel.getNotSelect_marks();

		String createTableSQL = "CREATE TABLE " + paper_name + " (" +
			    "ques_id INT PRIMARY KEY, " +
			    "question VARCHAR(600) NOT NULL, " +
			    "option_A VARCHAR(220) NOT NULL, " +
			    "option_B VARCHAR(220) NOT NULL, " +
			    "option_C VARCHAR(220) NOT NULL, " +
			    "option_D VARCHAR(220) NOT NULL, " +
			    "ans_op CHAR(1) NOT NULL, " +
			    "optionMarks CHAR(2) NOT NULL, " +
			    "notOptionMarks CHAR(2) NOT NULL)";
		
		String insertDataSQL = "INSERT INTO " + paper_name +
				" (ques_id, question, option_A, option_B, option_C, option_D, ans_op, optionMarks, notOptionMarks) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
		
		// `paper_id`, `paper_Name`, `total_ques`, `option_ques`, `notOption_ques`
		String insertPaperNameSQL = "INSERT INTO paper_name_all (paper_Name, total_ques, option_ques, notOption_ques, admin_id) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement psCreate = con.prepareStatement(createTableSQL);
             PreparedStatement psPaper = con.prepareStatement(insertPaperNameSQL);
             PreparedStatement psInsert = con.prepareStatement(insertDataSQL)) {
			
			psCreate.execute();
		     
			psPaper.setString(1, paper_name);
			psPaper.setInt(2, total_ques);
			psPaper.setInt(3, select_ques);
			psPaper.setInt(4, notSelect_ques);
			psPaper.setInt(5, adminId);
			psPaper.executeUpdate();
		     
		     for(QuestionPaperQuestionDataModel quetionInfo: questionDataStrore) {
					int question_no = quetionInfo.getQuestion_no();
				 	String question = quetionInfo.getQuestion();
			        String option_a = quetionInfo.getOption_a();
			        String option_b = quetionInfo.getOption_b();
			        String option_c = quetionInfo.getOption_c();
			        String option_d = quetionInfo.getOption_d();
			        String answer = quetionInfo.getAnswer();
			        String optionMarks ="0", notOptionMarks="0";
			        
			        if(question_no<=select_ques) {
			        		optionMarks = select_marks;
			        }else {
			        		notOptionMarks=notSelect_marks;
			        }
			        
			        psInsert.setInt(1, question_no);
			        psInsert.setString(2, question);
			        psInsert.setString(3, option_a);
			        psInsert.setString(4, option_b);
			        psInsert.setString(5, option_c);
			        psInsert.setString(6, option_d);
			        psInsert.setString(7, answer);
			        psInsert.setString(8, optionMarks);
			        psInsert.setString(9, notOptionMarks);
			        psInsert.addBatch();
			}
		     psInsert.executeBatch();			
		 }catch(Exception e) {
			 message_error="Data Inserted Failed";
			 e.printStackTrace();
		 }
		return message_error;
	}
}