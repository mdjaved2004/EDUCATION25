package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.SubCourseAndSubCourseSortIdWithMessageModel;

public class Education25CourseOpenMainDaoImpl implements Education25CourseOpenMainDao {

	@Override
	public SubCourseAndSubCourseSortIdWithMessageModel getSubCourseInfoDao(String course_name, String course_id) {
		SubCourseAndSubCourseSortIdWithMessageModel getFirstFreeSubCourseInfo=null;
		String message_error =null;
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			PreparedStatement ps=con.prepareStatement("SELECT sub_course_Name, sort_id FROM sub_courses WHERE course_id = ? AND price = 0 LIMIT 1");) {
			ps.setInt(1, Integer.parseInt(course_id));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				getFirstFreeSubCourseInfo = new SubCourseAndSubCourseSortIdWithMessageModel(
						rs.getString("sub_course_Name"), 						
						Integer.toString(rs.getInt("sort_id")),
						null);				
			}else {
				message_error="This Course Is Not Free, Try To Another Course";
				getFirstFreeSubCourseInfo = new SubCourseAndSubCourseSortIdWithMessageModel(null, null, message_error);
			}
			
		 }catch(Exception e) {
			 getFirstFreeSubCourseInfo=null;
			 e.printStackTrace();
		 }		
		return getFirstFreeSubCourseInfo;
	}
}