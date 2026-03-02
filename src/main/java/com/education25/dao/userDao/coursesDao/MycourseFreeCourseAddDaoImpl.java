package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class MycourseFreeCourseAddDaoImpl implements MycourseFreeCourseAddDao {

	@Override
	public String addFreeCourseDao(int sub_course_sort_id, int user_id) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			
			//Fist to check course is free or paid in dataBase 
			message_error = courseCheckFreeOrPaidInDataBase(con, sub_course_sort_id);
			if(message_error==null) {	
				// This method to add course.
				message_error =addCourseInMyCourse(con, sub_course_sort_id, user_id);
				if(message_error==null) {
					con.commit(); 						
				}else {
					con.rollback();
				}
			}else {				
				con.commit();
			}
		 }catch(Exception e) {
			 message_error="Something Wrong, Try again ";
			 e.printStackTrace();
		 }		
		return message_error;
	}
	
	private String courseCheckFreeOrPaidInDataBase(Connection con, int sub_course_sort_id) {
		String message_error =null;
		try (PreparedStatement ps = con.prepareStatement("SELECT price FROM sub_courses WHERE sort_id = ?")) {
	            ps.setInt(1, sub_course_sort_id);

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            		if(rs.getInt("price") != 0) {            	
	            			message_error = "This Course is Paid, First Buy Then Open";
	            		}
	            }else {
	            		message_error = "This Course Not Find, Add Another Course";
	            }
	        }catch(Exception e) {
	        		message_error = "Some thing Wrong, Try Again";
	        		e.printStackTrace();
	        }
		
		return message_error;
	}

	private String addCourseInMyCourse(Connection con, int sub_course_sort_id, int user_id) {
		int course1=0,course2=0,course3=0,course4=0,course5=0;
		String message_error=null, add_course_query=null;

		try (PreparedStatement ps = con.prepareStatement("SELECT * FROM add_free_courses WHERE user_id = ?")) {
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			  	course1=rs.getInt("course_1");
			  	course2=rs.getInt("course_2");
			  	course3=rs.getInt("course_3");
			  	course4=rs.getInt("course_4");
			  	course5=rs.getInt("course_5");
			  	
			  	String messageAndQuery[] = addCourseQuery(course1, course2, course3, course4, course5, sub_course_sort_id);
			  	if(messageAndQuery[0]==null && messageAndQuery[1]!=null) {
			  		add_course_query = messageAndQuery[1];
			  		try(PreparedStatement ps1 =con.prepareStatement(add_course_query);){
			  			ps1.setInt(1, sub_course_sort_id);
			  			ps1.setInt(2, user_id);
			  			
			  			int executeUpdate = ps1.executeUpdate();
			  			if(executeUpdate<=0) {
			  				message_error = "Failed to add Course, Try Again";
			  			}
			  		}			  		
			  	}else {
			  		message_error = messageAndQuery[0];
			  	}			  	
			}else {
				if(message_error==null) {
					//Add UserId and course
					message_error = addUserIdAddCourse(con, sub_course_sort_id, user_id);
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return message_error;		
	}
	
	private String[] addCourseQuery(int course1, int course2, int course3, int course4, int course5, int new_sub_course_sort_id) {
		String message_error =null, add_course_query=null, add_course_check =null;
		String messageAndQuery[] =new String[2]; 
		
		if(course1 == new_sub_course_sort_id || course2 == new_sub_course_sort_id || course3 == new_sub_course_sort_id
				|| course4 == new_sub_course_sort_id || course5 == new_sub_course_sort_id){
			message_error="This course already added . Click My Courses To Check";
		}
		if(message_error==null) {
			if (course1 == 0) {
				add_course_check = "course_1";
			} else if (course2 == 0) {
				add_course_check = "course_2";
			} else if (course3 == 0) {
				add_course_check = "course_3";
			} else if (course4 == 0) {
        	  		add_course_check = "course_4";
			} else if (course5 == 0) {
				add_course_check = "course_5";
			}else {
				message_error ="Max 5 Free Course Allow to Add";
			}
			
			if(add_course_check!=null && message_error == null) {
				add_course_query = "UPDATE add_free_courses SET " + add_course_check + " = ? WHERE user_id = ?";
			}
		}
		
		messageAndQuery[0] = message_error;
		messageAndQuery[1] = add_course_query;
		
		return messageAndQuery;		
	}
	private String addUserIdAddCourse(Connection con, int sub_course_sort_id, int user_id) {
		String message_error =null;
		
		try ( PreparedStatement ps = con.prepareStatement("INSERT INTO add_free_courses(user_id, course_1) VALUES (?, ?)");) {
			ps.setInt(1, user_id);
	          ps.setInt(2, sub_course_sort_id);
	          int executeUpdate = ps.executeUpdate();
	          if(executeUpdate<=0) {
	        	  	message_error = "Course Added Failed, Try Again";
	          }
	        }catch(Exception e) {
	        		message_error = "Some thing Wrong, Try Again";
	        		e.printStackTrace();
	        }		
		return message_error;
	}	
}