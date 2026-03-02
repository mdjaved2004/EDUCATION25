package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class MyCourseFreeCourseDeleteDaoImpl implements MyCourseFreeCourseDeleteDao {

	@Override
	public String removeSubCourseInMycourseDao(int sub_course_sort_id_int, int user_id) {
		String message_error =null;
	
		message_error = removeSubCourse(sub_course_sort_id_int, user_id);
			
		return message_error;
	}

	private String removeSubCourse(int sub_course_sort_id_int, int user_id) {
		int course1=0, course2=0, course3=0, course4=0, course5=0;
		String course_column=null , message_error=null;
		
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM add_free_courses WHERE user_id = ?");) {
			
			ps.setInt(1, user_id);
		    ResultSet rs = ps.executeQuery();

		    if (rs.next()) {
			    	course1=rs.getInt("course_1");
			    	course2=rs.getInt("course_2");
			    	course3=rs.getInt("course_3");
			    	course4=rs.getInt("course_4");
			    	course5=rs.getInt("course_5");
			    
			    	if(course1 == sub_course_sort_id_int){
			    		course_column="course_1";
		        }else if(course2==sub_course_sort_id_int){
		        		course_column="course_2";	
		        }else if(course3==sub_course_sort_id_int){
		        		course_column="course_3";
		        }else if(course4==sub_course_sort_id_int){
		        		course_column="course_4";	
		        }else if(course5==sub_course_sort_id_int){
		        		course_column="course_5";
		        }
		    }
		    	
			if(course_column!=null) {
		    		String update_query = "UPDATE add_free_courses SET " + course_column + " = 0 WHERE user_id = ?";
	
		    		PreparedStatement ps1 = con.prepareStatement(update_query);
		    		ps1.setInt(1, user_id);
	
		    		int rs1 = ps1.executeUpdate();
		    		if(!(rs1 > 0)) {
		    			message_error = "This course was not found";
		    		}
			}
			
			}catch(Exception e) {
			 message_error="Something Wrong, Try again ";
			 e.printStackTrace();
		 }		
		return message_error;
	}
}