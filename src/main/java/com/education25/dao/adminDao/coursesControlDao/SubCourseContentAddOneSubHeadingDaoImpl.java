package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneSubHeadingFormModel;

public class SubCourseContentAddOneSubHeadingDaoImpl implements SubCourseContentAddOneSubHeadingDao {

	@Override
	public String addOneSubHeadingDao(SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();){
			con.setAutoCommit(false);
			message_error = addSubHeadingDao(con, subHeadingFormModel);
			if (message_error != null) {
	            con.rollback();
	        } else {
	            con.commit(); 
	        }
			}catch(Exception e) {
				e.printStackTrace();
				return "Data inserted Failed, try agin";
			}
			return message_error;
	}

	@Override
	public String addSubHeadingDao(Connection con, SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel) {
		String heading_id=null, sub_course_name=null, sub_course_short_id=null;
		String sub_heading_id=null, sub_heading_text=null,sub_heading_definition=null,sub_heading_example=null;
		
		sub_course_name = subHeadingFormModel.getSub_course_name();
		sub_course_short_id = subHeadingFormModel.getSub_course_short_id();
		
		heading_id = subHeadingFormModel.getHeading_id();
		sub_heading_id = subHeadingFormModel.getSub_heading_id();
		sub_heading_text = subHeadingFormModel.getSub_heading_text();
		sub_heading_definition = subHeadingFormModel.getSub_heading_definition();
		sub_heading_example = subHeadingFormModel.getSub_heading_example();
		
	  String drop_primary_key_on_table = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" DROP PRIMARY KEY";
	  String sub_heading_coloum_id_upgrade = "UPDATE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" SET sub_heading_id = sub_heading_id + 1 WHERE sub_heading_id >= ? ";
	  String insert_one_sub_heading = "INSERT INTO " + sub_course_name + "_sub_heading_"+ sub_course_short_id +"(sub_heading_id, sub_heading_name, definition, example, heading_id) VALUES(?, ?, ?, ?, ?)";			
	  String apply_primary_key = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" ADD PRIMARY KEY (sub_heading_id)";
      
	  try{ 
        		PreparedStatement preparedStatement = null;
		    
        		// Step 1: Drop Primary key.       
        		preparedStatement = con.prepareStatement(drop_primary_key_on_table);
			preparedStatement.executeUpdate();
			
			// Step 2: Upgrade Sub heading column id. 
			preparedStatement = con.prepareStatement(sub_heading_coloum_id_upgrade);
			preparedStatement.setInt(1, Integer.parseInt(sub_heading_id));
			preparedStatement.executeUpdate();
			
			// Step 3: Insert data.
			preparedStatement = con.prepareStatement(insert_one_sub_heading);
			preparedStatement.setInt(1, Integer.parseInt(sub_heading_id));
			preparedStatement.setString(2, sub_heading_text);
			preparedStatement.setString(3, sub_heading_definition);
			preparedStatement.setString(4, sub_heading_example);
			preparedStatement.setInt(5, Integer.parseInt(heading_id));
			preparedStatement.executeUpdate();
			
			// Step 1: Apply Primary key.
			preparedStatement = con.prepareStatement(apply_primary_key);
			preparedStatement.executeUpdate();
	               
        } catch (Exception e) {
			e.printStackTrace();
			return "Try agin Data inserted failed";
		} 
        return null;
	}
}