package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperUpdateFormDataGetModel;

public class QuestionPaperUpdateFormDaoImpl implements QuestionPaperUpdateFormDao{

	@Override
	public QuestionPaperUpdateFormDataGetModel getPaperNameBasedOnAdminDao(int adminId) {
		String message_error=null;
		List<String> paperNameList = new ArrayList<String>();
		
		String getPaperNameQuery="SELECT paper_Name FROM paper_name_all WHERE admin_id = ? ";
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
		      PreparedStatement ps = con.prepareStatement(getPaperNameQuery)) {

		        ps.setInt(1, adminId);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        		paperNameList.add(rs.getString("paper_Name"));
		            }
		        if (paperNameList.isEmpty()) {
		        		message_error = "Paper Name not available, Please First to create paper Then update";
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		return new QuestionPaperUpdateFormDataGetModel(paperNameList, message_error);
	}
}