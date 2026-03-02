package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentUpdateFormModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseMainContentModel;

public class SubCourseContentUpdateViewDaoImpl implements SubCourseContentUpdateViewDao{

	@Override
	public SubCourseMainContentModel checkCourseAndSubCourseDao(SubCourseContentUpdateFormModel subCourseContentFormModel) {
		SubCourseMainContentModel subCourseMainContentModel=null;
		String message_error=null;
		String checkExistsSubCourseQuery="SELECT sub_course_Id, sub_course_Name, sort_id, course_id FROM sub_courses WHERE sub_course_Name = ? AND course_id = ? AND admin_id = ? LIMIT 1 ";
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			PreparedStatement ps=con.prepareStatement(checkExistsSubCourseQuery)) {
			con.setAutoCommit(false);
			ps.setString(1, subCourseContentFormModel.getSubCourseName());
			ps.setInt(2, subCourseContentFormModel.getCourseId());
			ps.setInt(3, subCourseContentFormModel.getAdminId());
			ResultSet executeQuery = ps.executeQuery();
			
			if(executeQuery.next()) {
				subCourseMainContentModel=new SubCourseMainContentModel(executeQuery.getInt("sub_course_Id"), executeQuery.getString("sub_course_Name"), executeQuery.getInt("sort_id"), executeQuery.getInt("course_id"), message_error);
			}else {
				message_error ="You are not aligible to update and delete this course";
			}
			con.commit();
			 
		 }catch(Exception e) {
			 message_error="You are fil wrong informatiob, Please fil right information";
			 e.printStackTrace();
		 }
		if(message_error!=null) {
			subCourseMainContentModel=new SubCourseMainContentModel(0, null, 0, 0, message_error);
		}
		return subCourseMainContentModel;
	}
}