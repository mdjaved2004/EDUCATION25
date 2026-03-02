package com.education25.dao.userDao.onlineExamAndCertificateDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel;

public class GetCertificateDaoImpl implements GetCertificateDao {

	@Override
	public List<GetCertificateModel> getcerticicateRecordsDao(int user_id) {
		
		List<GetCertificateModel> result = new ArrayList<GetCertificateModel>();
		
		try(Connection con=new ConnectionFactoryImpl().getConnForEducation25QuestionInfo()){
	
			String getRecordQuery="SELECT subject, marks_percentage FROM test_record WHERE user_resi_id = ? ";
			PreparedStatement ps=con.prepareStatement(getRecordQuery);
			ps.setInt(1, user_id);
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				result.add(new GetCertificateModel(executeQuery.getString("subject"), executeQuery.getString("marks_percentage")));
			}
		} catch (Exception e) {
			result.clear();
			e.printStackTrace();
		}
		return result;
	}
}