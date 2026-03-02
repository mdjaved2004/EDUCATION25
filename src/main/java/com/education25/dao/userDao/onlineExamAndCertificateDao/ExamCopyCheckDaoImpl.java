package com.education25.dao.userDao.onlineExamAndCertificateDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.commonModel.MessageAndErrormessageModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;

public class ExamCopyCheckDaoImpl implements ExamCopyCheckDao {

	@Override
	public MessageAndErrormessageModel copyCkeckAndStoreDataDao(int user_resister_id, String[] resultStore, ExamStartPaperInformation paperInforStore) {
		int i = 0,totalMarks=0, correctAnsMarks = 0, marksCountCount=0;
		float marksCountPercent=0.f;
		String userAnsStoreString ="", correctAns = null, optionMarks = null, notOptionMarks = null
				,message=null ,message_error=null;
		
		String copy_check_query = "SELECT ans_op, optionMarks, notOptionMarks FROM " + paperInforStore.getPaper_Name();
		
		try(Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()) {		
			con.setAutoCommit(false);			
			PreparedStatement ps = con.prepareStatement(copy_check_query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String answer=resultStore[i];
				correctAns = rs.getString("ans_op");

				optionMarks = rs.getString("optionMarks");
				notOptionMarks = rs.getString("notOptionMarks");
				if (answer != null && answer.equals(correctAns)) {
					if ("0".equals(notOptionMarks)) {
						correctAnsMarks = Integer.parseInt(optionMarks);
					} else {
						correctAnsMarks = Integer.parseInt(notOptionMarks);
					}
					marksCountCount += correctAnsMarks;
				}
				if(!optionMarks.equals("0")){
					totalMarks += Integer.parseInt(optionMarks);
				}else {
					totalMarks += Integer.parseInt(notOptionMarks);
				}
				i++;
			}
			marksCountPercent =(float) (Math.round(((float)(marksCountCount * 100) /(float) totalMarks) * 100.0) / 100.0);
			
			for (i = 0; i < resultStore.length; i++) {
				if(resultStore[i]==null) {
					userAnsStoreString +=",";					
				}else {
					userAnsStoreString +=resultStore[i]+",";
				}
			}
			
			//Store result data.
			String storedata = "INSERT INTO test_record (user_resi_id, subject, marks_percentage, ans) VALUES (?, ?, ?, ?)";
			PreparedStatement ps1 = con.prepareStatement(storedata);

			ps1.setInt(1, user_resister_id);
			ps1.setString(2, paperInforStore.getPaper_Name());
			ps1.setFloat(3, marksCountPercent);
			ps1.setString(4, userAnsStoreString);
			int result = ps1.executeUpdate();
			if (result > 0) {
				message="Succesfull Given exam , Click to get certificate";
			}else {
				message_error="Something went wrong, Please try again";
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new MessageAndErrormessageModel(message, message_error);
	}
}