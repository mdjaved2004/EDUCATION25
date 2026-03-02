package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class AddNewSubcourseFormDaoImpl implements AddNewSubcourseFormDao {

	@Override
	public String checkSubcourseAvailableOrNot(String subCourse, int course_id) {
		String check_query_sub_cours_exist="SELECT * FROM sub_courses WHERE sub_course_Name = ? AND course_id= ? LIMIT 1";
		
		 try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo()) {
			 PreparedStatement ps = con.prepareStatement(check_query_sub_cours_exist);
			 ps.setString(1, subCourse);
		     ps.setInt(2, course_id);
			 ResultSet Rs = ps.executeQuery();
			 
			 if(Rs.next()) {
				 return "Subject name already exists, please use number at end of subject name";
			 } 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		return null;
	}
}