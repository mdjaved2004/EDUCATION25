package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneHeadingFormModel;

public class SubCourseContentAddOneHeadingDaoImpl implements SubCourseContentAddOneHeadingDao {

	@Override
	public String addOneHeadingDao(SubCourseContentAddOneHeadingFormModel modelFormData) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();){
			con.setAutoCommit(false);
			message_error = addHeadingDao(con, modelFormData);
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
	public String addHeadingDao(Connection con, SubCourseContentAddOneHeadingFormModel modelFormData) {
		String heading_id=null, heading_name=null, sub_course_name=null, sub_course_short_id=null;
		
		heading_id = modelFormData.getHeading_id();
		heading_name = modelFormData.getHeading_name();
		sub_course_name = modelFormData.getSub_course_name();
		sub_course_short_id = modelFormData.getSub_course_short_id();
			
     	String drop_foreign_key_in_child_table = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" DROP FOREIGN KEY "+ sub_course_name +"_sub_heading_"+ sub_course_short_id +"_ibfk_1";
        String drop_primary_key_on_table = "ALTER TABLE " + sub_course_name + "_heading_"+ sub_course_short_id +" DROP PRIMARY KEY";
        String heading_coloum_id_upgrade = "UPDATE " + sub_course_name + "_heading_"+ sub_course_short_id +" SET heading_id = heading_id + 1 WHERE heading_id >= ?";
        String one_heading_add = "INSERT INTO " + sub_course_name + "_heading_"+ sub_course_short_id +"(heading_id, heading_name) VALUES(?, ?)";
        String apply_primary_key = "ALTER TABLE " + sub_course_name + "_heading_"+ sub_course_short_id +" ADD PRIMARY KEY (heading_id)";
        String subheading_coloum_id_upgrade = "UPDATE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" SET heading_id = heading_id + 1 WHERE heading_id >= ?";
        String apply_foreign_key_in_child_table = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" ADD CONSTRAINT " + sub_course_name + "_sub_heading_"+sub_course_short_id+"_ibfk_1 FOREIGN KEY (heading_id) REFERENCES " + sub_course_name + "_heading_"+ sub_course_short_id +"(heading_id)";
		     	
        try{ 
        		PreparedStatement preparedStatement = null;
		            
            // Step 1: Drop the foreign key constraint from the child table
            preparedStatement = con.prepareStatement(drop_foreign_key_in_child_table);
            preparedStatement.executeUpdate();
			                
            // Step 2: Drop the primary key from the heading table
            preparedStatement = con.prepareStatement(drop_primary_key_on_table);
            preparedStatement.executeUpdate();
			                
            // Step 3: Update heading_ids in the heading table
            preparedStatement = con.prepareStatement(heading_coloum_id_upgrade);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.executeUpdate();
			                
            // Step 4: Insert a new heading record
            preparedStatement = con.prepareStatement(one_heading_add);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.setString(2, heading_name);
            preparedStatement.executeUpdate();
			                
            // Step 5: Add the primary key back to the heading table
            preparedStatement = con.prepareStatement(apply_primary_key);
            preparedStatement.executeUpdate();
           
            preparedStatement = con.prepareStatement(subheading_coloum_id_upgrade);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.executeUpdate();
			                
            // Step 6: Add the foreign key constraint back to the child table
            preparedStatement = con.prepareStatement(apply_foreign_key_in_child_table);
            preparedStatement.executeUpdate();
			                
			               
        } catch (Exception e) {
			e.printStackTrace();
			return "Try agin Data inserted failed";
		} 
        return null;
	}
}