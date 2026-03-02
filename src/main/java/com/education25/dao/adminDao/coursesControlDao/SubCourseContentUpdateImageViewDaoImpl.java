package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageGetInformationModel;

public class SubCourseContentUpdateImageViewDaoImpl implements SubCourseContentUpdateImageViewDao {

	@Override
	public SubCourseImageGetInformationModel getSubcourseImageLinkService(String sub_course_short_id) {
		String price= null, learning_days=null, image_link=null;
		
		String getImagelinkQuery = "SELECT price, learningDays, image_link FROM sub_courses WHERE sort_id = ? ";
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			 PreparedStatement ps=con.prepareStatement(getImagelinkQuery);){
			
			ps.setInt(1, Integer.parseInt(sub_course_short_id));
			
			ResultSet rs = ps.executeQuery();			
			if(rs.next()) {
				price = rs.getString("price");
				learning_days = rs.getString("learningDays");
				image_link = rs.getString("image_link");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new SubCourseImageGetInformationModel(image_link, price, learning_days);
	}
}