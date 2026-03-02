package com.education25.dao.ServletContextDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class CoursesInformationGetDaoImpl implements CoursesInformationGetDao{
	
	@Override
	public List<CoursesInformationGetModel> coursesInformationDao() {
		List<CoursesInformationGetModel> courses = new ArrayList<>();
		Connection conEdu25CourseInfo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		 conEdu25CourseInfo = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
		 ps = conEdu25CourseInfo.prepareStatement("select * from courses");
		 rs = ps.executeQuery();

		 while(rs.next()){
				//this line data bind in class and add list.
				courses.add(new CoursesInformationGetModel(rs.getInt("course_id"),rs.getString("course_name"), rs.getInt("noOfSubCourses")));
		 }
		} catch (Exception e) {
			courses.clear();
		}
		return courses;
	}
	
	@Override
	public Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesDao() {
		Map<CoursesInformationGetModel, List<SubCourseInformationModel>> courseAndsubSourseInfo = new LinkedHashMap<>();
		Connection conEdu25CourseInfo = null;
		PreparedStatement ps = null,ps1 = null;
		ResultSet rs = null, rs1 = null;
		
		try {
		 conEdu25CourseInfo = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
		 
		 conEdu25CourseInfo.setAutoCommit(false);
		 ps = conEdu25CourseInfo.prepareStatement("select * from courses ORDER BY course_id ASC LIMIT 10");
		 rs = ps.executeQuery();
		 while(rs.next()){
			 if(rs.getInt("noOfSubCourses")>0) {
				 List<SubCourseInformationModel> subCourseInfo = new ArrayList<>();
				 CoursesInformationGetModel coursesInformationGetModel = new CoursesInformationGetModel(rs.getInt("course_id"), rs.getString("course_name"), rs.getInt("noOfSubCourses"));
				 String sub_courses_query="select sub_course_Id, sub_course_Name, learningDays, price, sort_id, image_link from sub_courses where course_id = ? AND is_active = true LIMIT 10";
				 ps1 = conEdu25CourseInfo.prepareStatement(sub_courses_query);
				 ps1.setInt(1, rs.getInt("course_id"));
				 rs1 = ps1.executeQuery();
				 while(rs1.next()){
					 //`sub_course_Id`, `sub_course_Name`, `learningDays`, `price`, `course_id`, `sort_id`, `admin_id`, `image_link`, `image_add_admin_id`
					 subCourseInfo.add(new SubCourseInformationModel(rs1.getInt("sub_course_Id"), rs1.getString("sub_course_Name"), rs1.getString("image_link"), rs1.getInt("price"), rs1.getInt("sort_id"), rs1.getInt("learningDays")));
			 	}
				 courseAndsubSourseInfo.put(coursesInformationGetModel, subCourseInfo);
			 	}
			 }
		 conEdu25CourseInfo.commit();
		}catch (SQLException e) {
			courseAndsubSourseInfo.clear();
		}
		return courseAndsubSourseInfo;
	}
}