package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseHeadingUpdateModel;

public class SubCourseContentUpdateHeadingDaoImpl implements SubCourseContentUpdateHeadingDao {

	@Override
	public String updateHeadingDao(SubCourseHeadingUpdateModel subCourseHeadingUpdateModel) {
		String message_error=null;
		String heading_update_query = "UPDATE " + subCourseHeadingUpdateModel.getSub_course_name() + "_heading_"+ subCourseHeadingUpdateModel.getSub_course_short_id() +" SET heading_name = ? WHERE heading_id = ?";
	
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			 PreparedStatement ps = con.prepareStatement(heading_update_query)) {
			
			ps.setString(1, subCourseHeadingUpdateModel.getHeading_text()); 
			ps.setInt(2, Integer.parseInt(subCourseHeadingUpdateModel.getHeading_id())); 
			
			int rowsUpdated = ps.executeUpdate(); 
		    	if (rowsUpdated <= 0) {
		    		message_error= "Heading Not find.";
		    	}
			
		}catch(Exception e) {
			message_error="Server error, Please try again";
		}
		return message_error;
	}
}