package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentRemoveOneSubHeadingModel;

public class SubCourseContentRemoveOneSubHeadingDaoImpl implements SubCourseContentRemoveOneSubHeadingaDao {

	@Override
	public String removeOneSubHeadingDao(SubCourseContentRemoveOneSubHeadingModel removeOneSubHeadingModel) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();){
			con.setAutoCommit(false);
			message_error = removeSubHeadingDao(con, removeOneSubHeadingModel);
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
	public String removeSubHeadingDao(Connection con, SubCourseContentRemoveOneSubHeadingModel removeOneSubHeadingModel) {
		String heading_id=null, sub_course_name=null, sub_course_short_id=null;
		String sub_heading_id=null;
		
		sub_course_name = removeOneSubHeadingModel.getSub_course_name();
		sub_course_short_id = removeOneSubHeadingModel.getSub_course_short_id();
		
		heading_id = removeOneSubHeadingModel.getHeading_id();
		sub_heading_id = removeOneSubHeadingModel.getSub_heading_id();
		
		String delete_row_subheading="DELETE FROM " + sub_course_name + "_sub_heading_"+ sub_course_short_id +" WHERE sub_heading_id = ? AND heading_id = ?";
		String rearrange_coloum_id_subheading =" UPDATE " + sub_course_name + "_sub_heading_"+ sub_course_short_id +"	SET sub_heading_id = (@row_number := @row_number + 1)  WHERE (@row_number := 0) IS NOT NULL ORDER BY sub_heading_id";
	  try{ 
	    		PreparedStatement preparedStatement = null;
		    	    		     
	    		preparedStatement = con.prepareStatement(delete_row_subheading);
	    		preparedStatement.setInt(1, Integer.parseInt(sub_heading_id));
	    		preparedStatement.setInt(2, Integer.parseInt(heading_id));			
	    		preparedStatement.executeUpdate();
	    		
	    		preparedStatement = con.prepareStatement(rearrange_coloum_id_subheading);
			preparedStatement.executeUpdate();
	               
	    } catch (Exception e) {
			e.printStackTrace();
			return "Try agin Data inserted failed";
		} 
	    return null;
	}
}