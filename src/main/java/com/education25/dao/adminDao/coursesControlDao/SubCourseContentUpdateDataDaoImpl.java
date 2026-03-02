package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseFullInformationModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseHeadingModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseSubHeadingModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class SubCourseContentUpdateDataDaoImpl implements SubCourseContentUpdateDataDao {
	@Override
	public SubCourseFullInformationModel subCourseContentUpdateDataDao(String subCourseName, String sortId) {
		SubCourseFullInformationModel courseContent=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			courseContent = getCourseContent(subCourseName, sortId, con);
			con.commit(); 
		 }catch(Exception e) {
			 courseContent=null;
			 e.printStackTrace();
		 }
		
		return courseContent;
	}

	@Override
	public SubCourseFullInformationModel getCourseContent(String subCourseName, String sortId, Connection con) {
		List<SubCourseHeadingModel> subCourseHeading = new ArrayList<SubCourseHeadingModel>();
		List<SubCourseSubHeadingModel> subCourseSubHeading = new ArrayList<SubCourseSubHeadingModel>();
		String message_error=null;
		
		subCourseName = new ReplaceSpaceTo_().replaceSpaceTo_(subCourseName);
		String headingQuery ="SELECT * FROM 	" +subCourseName+"_heading_"+sortId+" ";
		String subHeadingQuery ="SELECT * FROM " +subCourseName+"_sub_heading_"+sortId+ " ";
		
		try (PreparedStatement ps1=con.prepareStatement(headingQuery);
			PreparedStatement ps2=con.prepareStatement(subHeadingQuery);
			){
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				subCourseHeading.add(
					new SubCourseHeadingModel(
						rs1.getInt("heading_id"),
						rs1.getString("heading_name")
						)
					);
			}
			ResultSet rs2 = ps2.executeQuery();
			//`sub_heading_id`, `sub_heading_name`, `definition`, `example`, `heading_id`
			while(rs2.next()) {
				subCourseSubHeading.add(
					new SubCourseSubHeadingModel(
						rs2.getInt("heading_id"),
						rs2.getInt("sub_heading_id"),
						rs2.getString("sub_heading_name"),
						rs2.getString("definition"),
						rs2.getString("example")
						)
					);
			}
			
		}catch(Exception e) {
			subCourseHeading.clear();
			subCourseSubHeading.clear();
			message_error="This course is not available";
			e.printStackTrace();
		 }		
		return new SubCourseFullInformationModel(subCourseHeading, subCourseSubHeading, message_error);
	}
}