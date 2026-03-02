package com.education25.dao.ServletContextDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.ServletContextModel.OnlineExamContextModel;

public class OnlineExamInformationGetDaoImpl implements OnlineExamInformationGetDao {

	@Override
	public List<OnlineExamContextModel> getOnlineExamContext() {
		
		List<OnlineExamContextModel> onlineContext=new ArrayList<>();
		
		try(Connection con=new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
			PreparedStatement ps=con.prepareStatement("SELECT paper_id, paper_Name, total_ques, option_ques, notOption_ques, image_link FROM paper_name_all")){
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				onlineContext.add(new OnlineExamContextModel(
						executeQuery.getInt("paper_id"),
						executeQuery.getString("paper_Name"),
						executeQuery.getInt("total_ques"),
						executeQuery.getInt("option_ques"),
						executeQuery.getInt("notOption_ques"),
						executeQuery.getString("image_link")
						));
				}
			
		}catch(Exception e) {
			onlineContext.clear();
			e.printStackTrace();
		}
		
		return onlineContext;
	}
}