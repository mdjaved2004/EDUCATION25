package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseSubHeadingUpdateModel;

public class SubCourseContentUpdateSubHeadingDaoImpl implements SubCourseContentUpdateSubHeadingDao {
	@Override
	public String updateSubHeadingDao(SubCourseSubHeadingUpdateModel subCourseSubHeadingUpdateModel) {
		String message_error=null;
		String sub_heading_update_query = "UPDATE " + subCourseSubHeadingUpdateModel.getSub_course_name() + "_sub_heading_"+ subCourseSubHeadingUpdateModel.getSub_course_short_id() +" SET sub_heading_name = ?, definition = ?, example = ? WHERE sub_heading_id = ? AND heading_id = ? ";
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			 PreparedStatement ps = con.prepareStatement(sub_heading_update_query)) {
			
			ps.setString(1,subCourseSubHeadingUpdateModel.getSub_heading_text());
			ps.setString(2, subCourseSubHeadingUpdateModel.getSub_heading_definition());
			ps.setString(3, subCourseSubHeadingUpdateModel.getSub_heading_example());
			ps.setInt(4, Integer.parseInt(subCourseSubHeadingUpdateModel.getSub_heading_id())); 
			ps.setInt(5, Integer.parseInt(subCourseSubHeadingUpdateModel.getHeading_id())); 
			
			int rowsUpdated = ps.executeUpdate(); 
		    	if (rowsUpdated <= 0) {
		    		message_error= "sub Heading Not find.";
		    	}
			
		}catch(Exception e) {
			message_error="Server error, Please try again";
		}
		return message_error;
	}
}