package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.SubCourseHeadingContentGetModel;
import com.education25.model.userModel.coursesModel.SubCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseOpenFormDataHoldModel;
import com.education25.model.userModel.coursesModel.SubCourseRelativeCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseSubHeadingContentGetModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class Education25CourseOpenDaoImpl implements Education25CourseOpenDao {

	@Override
	public SubCourseInformationGetModel subCourseInformationDao(SubCourseOpenFormDataHoldModel subCourseOpenFormDataHoldModel) {
		SubCourseInformationGetModel courseContent=null;
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			message_error = checkSubcourse(subCourseOpenFormDataHoldModel, con);			
			if(message_error==null) {
				courseContent = getCourseContent(subCourseOpenFormDataHoldModel, con);		
			}else {
				new SubCourseInformationGetModel(null, null, null, message_error);
			}
			con.commit(); 
		 }catch(Exception e) {
			 courseContent=null;
			 e.printStackTrace();
		 }		
		return courseContent;
	}


	public SubCourseInformationGetModel getCourseContent(SubCourseOpenFormDataHoldModel subCourseOpenFormDataHoldModel, Connection con) {
		List<SubCourseHeadingContentGetModel> subCourseHeading = new ArrayList<SubCourseHeadingContentGetModel>();
		List<SubCourseSubHeadingContentGetModel> subCourseSubHeading = new ArrayList<SubCourseSubHeadingContentGetModel>();
		List<SubCourseRelativeCourseInformationGetModel> subCourseRelative = new ArrayList<SubCourseRelativeCourseInformationGetModel>();
		
		String message_error=null, sub_course_name= null, sub_course_sort_id=null;
		int course_id=0;
		
		sub_course_name = new ReplaceSpaceTo_().replaceSpaceTo_(subCourseOpenFormDataHoldModel.getSub_course_name());
		sub_course_sort_id = subCourseOpenFormDataHoldModel.getSub_course_sort_id();
		course_id = Integer.parseInt(subCourseOpenFormDataHoldModel.getCourse_id());
		
		String headingQuery ="SELECT * FROM 	" +sub_course_name+"_heading_"+sub_course_sort_id+" ";
		String subHeadingQuery ="SELECT * FROM " +sub_course_name+"_sub_heading_"+sub_course_sort_id+ " ";
		String relativeSubCourseGet = "SELECT sub_course_Name, sort_id FROM sub_courses WHERE course_id = ? AND price = 0 ";
		
		try (PreparedStatement ps1=con.prepareStatement(headingQuery);
			PreparedStatement ps2=con.prepareStatement(subHeadingQuery);
			PreparedStatement ps3=con.prepareStatement(relativeSubCourseGet);
			){
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				subCourseHeading.add(
					new SubCourseHeadingContentGetModel(
						rs1.getInt("heading_id"),
						rs1.getString("heading_name")
						)
					);
			}
			ResultSet rs2 = ps2.executeQuery();
			//`sub_heading_id`, `sub_heading_name`, `definition`, `example`, `heading_id`
			while(rs2.next()) {
				subCourseSubHeading.add(
					new SubCourseSubHeadingContentGetModel(
						rs2.getInt("heading_id"),
						rs2.getInt("sub_heading_id"),
						rs2.getString("sub_heading_name"),
						rs2.getString("definition"),
						rs2.getString("example")
						)
					);
			}
			
			ps3.setInt(1, course_id);
			ResultSet rs3 = ps3.executeQuery();
			while(rs3.next()) {
				subCourseRelative.add(
					new SubCourseRelativeCourseInformationGetModel(			
							rs3.getString("sort_id"),
							rs3.getString("sub_course_Name")
						
						)
					);
			}
			
		}catch(Exception e) {
			subCourseHeading.clear();
			subCourseSubHeading.clear();
			message_error="This course is not available";
			e.printStackTrace();
		 }		
		return new SubCourseInformationGetModel(subCourseHeading, subCourseSubHeading, subCourseRelative, message_error);
	}
	
	public String checkSubcourse(SubCourseOpenFormDataHoldModel subCourseOpenFormDataHoldModel, Connection con) {
		String message_error=null, sub_course_name= null;
		
		String checkSubCourseQury = "SELECT sub_course_Name, sort_id, price FROM sub_courses WHERE sub_course_Name =? AND course_id = ? LIMIT 1";
		sub_course_name= new ReplaceSpaceTo_().replaceSpaceTo_(subCourseOpenFormDataHoldModel.getSub_course_name());
		
		try (PreparedStatement checkSubCourse=con.prepareStatement(checkSubCourseQury)){
			checkSubCourse.setString(1, sub_course_name);
			checkSubCourse.setInt(2, Integer.parseInt(subCourseOpenFormDataHoldModel.getCourse_id()));
			
			ResultSet rs = checkSubCourse.executeQuery();
			int price = 0;
			if(rs.next()) {
				price =rs.getInt("price");
				if(!(price==Integer.parseInt(subCourseOpenFormDataHoldModel.getPrice()))) {
					message_error="This Course Is Paid, First Buy Then Open";
				}
			}else {
				message_error="This Course Is Not Available, Try Another Course To Open";
			}
						
		}catch(Exception e) {
			message_error="This course is not available";
			e.printStackTrace();
		 }	
		
		return message_error;
	}
}