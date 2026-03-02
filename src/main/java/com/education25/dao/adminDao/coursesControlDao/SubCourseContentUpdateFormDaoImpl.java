package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCoursesAndCourseContentModel;
import com.education25.model.adminModel.coursesControlModel.SubCoursesContentListAndMessageModel;

public class SubCourseContentUpdateFormDaoImpl implements SubCourseContentUpdateFormDao {

	@Override
	public SubCoursesContentListAndMessageModel getinformationBasedOnAdminDao(int adminId) {
		String message_error=null;
	    List<SubCoursesAndCourseContentModel> list = new ArrayList<>();

	    String get_sub_course_info_query = "SELECT sub_course_Id, sub_course_Name, learningDays, price, " +
	                 "course_id, sort_id, admin_id, image_link, image_add_admin_id " +
	                 "FROM sub_courses WHERE admin_id = ?";

	    try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
	         PreparedStatement ps = con.prepareStatement(get_sub_course_info_query)) {

	        ps.setInt(1, adminId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
		        list.add(new SubCoursesAndCourseContentModel(
		        			rs.getInt("sub_course_Id"),
		        			rs.getString("sub_course_Name"),
		        			rs.getInt("learningDays"),
		        			rs.getInt("price"),
		        			rs.getInt("course_id"),
		        			rs.getInt("sort_id"),
		        			rs.getInt("admin_id"),
		        			rs.getString("image_link"),
		        			rs.getInt("image_add_admin_id")
		        		));
	            }
	        if (list.isEmpty()) {
	        		message_error = "Record not available";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return new SubCoursesContentListAndMessageModel(message_error, list);
	}	
}
