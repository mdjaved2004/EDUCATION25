package com.education25.dao.userDao.onlineExamAndCertificateDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartQuestionInformationModel;

public class ExamStartDaoImpl implements ExamStartDao {

	@Override
	public ExamStartModel getExamStartContextDao(String paperName, int paperId) {
		List<ExamStartQuestionInformationModel> questionInfo=new ArrayList<>();
		ExamStartPaperInformation paperInformationDao=null;
		String question_paper_query = "SELECT * FROM " + paperName;
		
		try(Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()) {		
			con.setAutoCommit(false);
			paperInformationDao = getPaperInformationDao(con, paperName, paperId);
				if(paperInformationDao!=null) {
					PreparedStatement ps = con.prepareStatement(question_paper_query);
					ResultSet executeQuery = ps.executeQuery();
					while(executeQuery.next()) {
						questionInfo.add(new ExamStartQuestionInformationModel(
						            executeQuery.getInt("ques_id"),
						            executeQuery.getString("question"),
						            executeQuery.getString("option_A"),
						            executeQuery.getString("option_B"),
						            executeQuery.getString("option_C"),
						            executeQuery.getString("option_D"),
						            executeQuery.getString("optionMarks"),
						            executeQuery.getString("notOptionMarks")
						        ));
					}
					con.commit();
				}			 
		}
		 catch (Exception e) {
			 questionInfo.clear();
			    e.printStackTrace();
			}
		return new ExamStartModel(paperInformationDao, questionInfo);
	}

	@Override
	public ExamStartPaperInformation getPaperInformationDao(Connection con, String paperName, int paperId) {
			ExamStartPaperInformation paperInfor=null;
			
			try(PreparedStatement ps=con.prepareStatement("SELECT paper_id, paper_Name, total_ques, option_ques, notOption_ques, image_link FROM paper_name_all WHERE paper_id =? AND paper_Name =? ")){
				ps.setInt(1, paperId);
				ps.setString(2, paperName);
				
				ResultSet executeQuery = ps.executeQuery();
			
					while(executeQuery.next()) {
						paperInfor= new ExamStartPaperInformation(
								executeQuery.getInt("paper_id"),
								executeQuery.getString("paper_Name"),
								executeQuery.getInt("total_ques"),
								executeQuery.getInt("option_ques"),
								executeQuery.getInt("notOption_ques")
							);
				}			
		}catch(Exception e) {
			paperInfor=null;
			e.printStackTrace();
		}
			
		return paperInfor;
	}
}