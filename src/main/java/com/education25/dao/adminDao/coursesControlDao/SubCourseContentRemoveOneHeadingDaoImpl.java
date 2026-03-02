package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentRemoveOneHeadingModel;

public class SubCourseContentRemoveOneHeadingDaoImpl implements SubCourseContentRemoveOneHeadingDao {
	@Override
	public String removeOneHeadingDao(SubCourseContentRemoveOneHeadingModel removeOneHeadingModel) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();){
			con.setAutoCommit(false);
			message_error = removeHeadingAndSubHeadingDao(con, removeOneHeadingModel);
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
	public String removeHeadingAndSubHeadingDao(Connection con, SubCourseContentRemoveOneHeadingModel removeOneHeadingModel) {
		String heading_id=null, sub_course_name=null, sub_course_short_id=null;
		
		sub_course_name = removeOneHeadingModel.getSub_course_name();
		sub_course_short_id = removeOneHeadingModel.getSub_course_short_id();
		
		heading_id = removeOneHeadingModel.getHeading_id();
		
		String drop_foreign_key_in_child_table = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" DROP FOREIGN KEY "+ sub_course_name +"_sub_heading_"+ sub_course_short_id +"_ibfk_1";
		String delete_row_heading="DELETE FROM " + sub_course_name + "_heading_"+ sub_course_short_id +" WHERE heading_id = ? ";
		String decrise_coloum_id_heading = "UPDATE " + sub_course_name + "_heading_"+ sub_course_short_id +" SET heading_id = heading_id - 1 WHERE heading_id > ?";
		String delete_row_subheading="DELETE FROM " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" WHERE heading_id = ? ";
		String decrise_coloum_heading_id_subheading = "UPDATE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" SET heading_id = heading_id - 1 WHERE heading_id > ?";
		String rearrange_coloum_id_subheading =" UPDATE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +"	SET sub_heading_id = (@row_number := @row_number + 1)  WHERE (@row_number := 0) IS NOT NULL ORDER BY sub_heading_id";
		String apply_foreign_key_in_child_table = "ALTER TABLE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" ADD CONSTRAINT " + sub_course_name + "_sub_heading_"+ sub_course_short_id +"_ibfk_1 FOREIGN KEY (heading_id) REFERENCES " + sub_course_name + "_heading_"+ sub_course_short_id +"(heading_id)";
		
	  try{ 
	    		PreparedStatement preparedStatement = null;
		    	    		     
	    		// Drop the foreign key.
            preparedStatement = con.prepareStatement(drop_foreign_key_in_child_table);
            preparedStatement.executeUpdate();
            
            //delete row in heading table.
            preparedStatement = con.prepareStatement(delete_row_heading);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.executeUpdate();

            preparedStatement = con.prepareStatement(decrise_coloum_id_heading);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.executeUpdate();
            
            preparedStatement = con.prepareStatement(delete_row_subheading);
            preparedStatement.setInt(1, Integer.parseInt(heading_id));
            preparedStatement.executeUpdate();
            
			preparedStatement = con.prepareStatement(decrise_coloum_heading_id_subheading);
			preparedStatement.setInt(1, Integer.parseInt(heading_id));
			preparedStatement.executeUpdate();
			
			preparedStatement = con.prepareStatement(rearrange_coloum_id_subheading);
			preparedStatement.executeUpdate();
        
         // Add the foreign key.
            preparedStatement = con.prepareStatement(apply_foreign_key_in_child_table);
            preparedStatement.executeUpdate();
	               
	    } catch (Exception e) {
			e.printStackTrace();
			return "Try agin Data inserted failed";
		} 
	    return null;
	}
}