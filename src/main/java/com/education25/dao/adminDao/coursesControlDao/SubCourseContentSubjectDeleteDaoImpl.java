package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentSubjectDeleteModel;

public class SubCourseContentSubjectDeleteDaoImpl implements SubCourseContentSubjectDeleteDao {

	@Override
	public String subCourseDeleteDao(SubCourseContentSubjectDeleteModel model) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();){
			con.setAutoCommit(false);
			message_error = deleteSubCourse(con, model);
			if (message_error != null) {
	            con.rollback();
	        } else {
	            con.commit(); 
	        }
			}catch(Exception e) {
				e.printStackTrace();
				return "Subject Delete Failed, try agin";
			}
			return message_error;
	}

	@Override
	public String deleteSubCourse(Connection con, SubCourseContentSubjectDeleteModel model) {
		String course_id=null, sub_course_name=null, sub_course_short_id=null;
		String headingEntityName=null, subHeadingEntityName=null, lectureEntityName=null;
		int admin_id =0;
		
		admin_id = model.getAdmin_id();
		course_id = model.getCourse_id();
		sub_course_name = model.getSub_course_name();
		sub_course_short_id = model.getSub_course_short_id();
		
		
		//`sub_course_Id`, `sub_course_Name`, `learningDays`, `price`, `course_id`, `sort_id`, `admin_id` `sub_courses`
     	String checkSubcourseExist = "SELECT sub_course_Id, sort_id FROM sub_courses WHERE  sort_id = ? AND course_id= ? AND sub_course_Name = ?";
     	String update_row_sub_courses = "UPDATE sub_courses SET is_active = FALSE WHERE sort_id = ? AND course_id = ? AND sub_course_Name = ?";

     	String noOfSubCourses_in_couses_update = "UPDATE courses SET noOfSubCourses = noOfSubCourses - 1 WHERE course_id = ?";

     	//Entities name
     	headingEntityName = sub_course_name + "_heading_"+ sub_course_short_id;
     	subHeadingEntityName = sub_course_name + "_sub_heading_"+ sub_course_short_id;
     	lectureEntityName = sub_course_name + "_lectures_"+ sub_course_short_id;
     	
     	//Query for delete table(actually alter, not Delete)
     	String alter_sub_headinh_table= "ALTER TABLE "+ subHeadingEntityName +" RENAME TO "+ subHeadingEntityName +"_"+admin_id+"";
     	String alter_heading_table= "ALTER TABLE "+ headingEntityName +" RENAME TO "+ headingEntityName +"_"+admin_id+"";
     	String alter_lectures_table= "ALTER TABLE "+ lectureEntityName +" RENAME TO "+ lectureEntityName +"_"+admin_id+"";
     	
     	PreparedStatement preparedStatement = null;
	 
     	try{ 
     		//Check course are exist or not exist.
     		preparedStatement = con.prepareStatement(checkSubcourseExist);
     		preparedStatement.setInt(1, Integer.parseInt(sub_course_short_id));
     		preparedStatement.setInt(2, Integer.parseInt(course_id));
     		preparedStatement.setString(3, sub_course_name);
     		ResultSet rs = preparedStatement.executeQuery();
     		
     		if(rs.next()) {
     			int sub_course_id =rs.getInt("sub_course_Id");
     			preparedStatement = con.prepareStatement(update_row_sub_courses);
     			preparedStatement.setInt(1, Integer.parseInt(sub_course_short_id));
         		preparedStatement.setInt(2, Integer.parseInt(course_id));
         		preparedStatement.setString(3, sub_course_name);
         		preparedStatement.executeUpdate();
         		
         		//Update number of sub courses in course entity
         		preparedStatement = con.prepareStatement(noOfSubCourses_in_couses_update);
         		preparedStatement.setInt(1, Integer.parseInt(course_id));
         		preparedStatement.executeUpdate();
         		
         		//Alter all table name which admin delete course(first check than alter).
         		if (isTableExist(con, subHeadingEntityName)) {
	         		preparedStatement = con.prepareStatement(alter_sub_headinh_table);
	         		preparedStatement.executeUpdate();
         		}
         		
         		if (isTableExist(con, headingEntityName)) {
	         		preparedStatement = con.prepareStatement(alter_heading_table);
	         		preparedStatement.executeUpdate(); 		
         		}
         		
         		if (isTableExist(con, lectureEntityName)) {
	         		preparedStatement = con.prepareStatement(alter_lectures_table);
	         		preparedStatement.executeUpdate();
         		}
     		}else {
     			return "THis course are not avalable , try agin";
     		}
             
        } catch (Exception e) {
			e.printStackTrace();
			return "Try agin Data inserted failed";
		} 
        return null;
	}
	
	private boolean isTableExist(Connection con, String tableName) {
	    if (tableName == null || con == null) return false;
	    try {
	        DatabaseMetaData dbm = con.getMetaData();
	        
	        // MySQL mein table names aksar Case Sensitive hote hain
	        try (ResultSet rs = dbm.getTables(null, null, tableName, new String[] {"TABLE"})) {
	            return rs.next();
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}
}