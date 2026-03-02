package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.BuyCoursesTextDataModel;
import com.education25.model.userModel.coursesModel.BuyCourseOpenInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseHeadingContentGetModel;
import com.education25.model.userModel.coursesModel.SubCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseNameWithMessageModel;
import com.education25.model.userModel.coursesModel.SubCourseRelativeCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseSubHeadingContentGetModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class BuyCourseOpenDaoImpl implements BuyCourseOpenDao {

	@Override
	public BuyCourseOpenInformationGetModel buyCourseOpenInformationDao(int user_id, String sub_course_sort_id) {
		BuyCourseOpenInformationGetModel courseContent=null;
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			
			courseContent = checkSubcourseAndGetAllBuyCourses(con, user_id, sub_course_sort_id);
			
			if(courseContent.getMessage_error() == null) {
				BuyCoursesTextDataModel buyCoursesTextData = getCourseContent(con, courseContent.getSub_course_name(), sub_course_sort_id);
				if(buyCoursesTextData.getMessage_error()!=null) {
					courseContent.setMessage_error(buyCoursesTextData.getMessage_error());
				}else {
					courseContent.setSubCourseHeading(buyCoursesTextData.getSubCourseHeading());
					courseContent.setSubCourseSubHeading(buyCoursesTextData.getSubCourseSubHeading());
				}
			}
			con.commit(); 
		 }catch(Exception e) {
			 courseContent=null;
			 e.printStackTrace();
		 }
		return courseContent;
	}

	public BuyCoursesTextDataModel getCourseContent(Connection con, String sub_course_name, String sub_course_sort_id) {
		List<SubCourseHeadingContentGetModel> subCourseHeading = new ArrayList<SubCourseHeadingContentGetModel>();
		List<SubCourseSubHeadingContentGetModel> subCourseSubHeading = new ArrayList<SubCourseSubHeadingContentGetModel>();
		
		String message_error=null;
		int course_id=0;
		
		sub_course_name = new ReplaceSpaceTo_().replaceSpaceTo_(sub_course_name);
		course_id = Integer.parseInt(sub_course_sort_id);
		
		String headingQuery ="SELECT * FROM 	" +sub_course_name+"_heading_"+sub_course_sort_id+" ";
		String subHeadingQuery ="SELECT * FROM " +sub_course_name+"_sub_heading_"+sub_course_sort_id+ " ";
		
		try (PreparedStatement ps1=con.prepareStatement(headingQuery);
			PreparedStatement ps2=con.prepareStatement(subHeadingQuery)){
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
						
		}catch(Exception e) {
			subCourseHeading.clear();
			subCourseSubHeading.clear();
			message_error="This course is not available";
			e.printStackTrace();
		 }		
		return new BuyCoursesTextDataModel(subCourseHeading, subCourseSubHeading, message_error);
	}
	
	public BuyCourseOpenInformationGetModel checkSubcourseAndGetAllBuyCourses(Connection con, int user_id, String sub_course_sort_id) {
		String sub_course_name=null, message_error=null;
		int subCourseSortId = 0;
		BuyCourseOpenInformationGetModel courseContent =null;
		List<SubCourseRelativeCourseInformationGetModel> subCourseRelative = new ArrayList<SubCourseRelativeCourseInformationGetModel>();
		
		
		// This query to check course is buy or not.
		String checkCourseBuy="SELECT buy_course_id FROM buy_courses WHERE user_id = ? AND course_short_id = ? LIMIT 1";
		
		//All buy course get.
		String getAllBuyCourses="SELECT b.course_short_id, sc.sub_course_Name FROM (SELECT * FROM buy_courses WHERE user_id = ?) b "
				+ "JOIN sub_courses sc ON b.course_short_id = sc.sort_id LIMIT 25";
		
		//`buy_course_id`, `user_id`, `course_short_id`, `order_id`, `razorpay_payment_id`, `razorpay_signature`, `amount`, `payment_success`, `buy_course_date`
		String checkSubCourseQury = "SELECT sub_course_Name, sort_id, price FROM sub_courses WHERE sort_id =? LIMIT 1";
		
		try (PreparedStatement checkCourseBuyPs=con.prepareStatement(checkCourseBuy);
			 PreparedStatement getAllBuyCoursesPs=con.prepareStatement(getAllBuyCourses);
			 PreparedStatement checkSubCourse=con.prepareStatement(checkSubCourseQury)){
			
			subCourseSortId = Integer.parseInt(sub_course_sort_id);
			
			checkCourseBuyPs.setInt(1, user_id);
			checkCourseBuyPs.setInt(2, subCourseSortId);
			
			ResultSet checkCourseBuyRs = checkCourseBuyPs.executeQuery();
			
			if(checkCourseBuyRs.next()) {
				checkSubCourse.setInt(1, subCourseSortId);
				ResultSet checkSubCourseRs = checkSubCourse.executeQuery();
				
				if(checkSubCourseRs.next()) {
					sub_course_name =checkSubCourseRs.getString("sub_course_Name");			
				}else {
					message_error="This Course Is Not Available, Try Another Course To Open";
				}		
			}else {
				message_error="This Course Is Paid, First Buy Then Open";
			}
			//Get All relative course which already buy course.
			if(sub_course_name!=null) {
				getAllBuyCoursesPs.setInt(1, user_id);
				ResultSet getAllBuyCoursesRs = getAllBuyCoursesPs.executeQuery();
				while(getAllBuyCoursesRs.next()) {
					subCourseRelative.add(
						    new SubCourseRelativeCourseInformationGetModel(
						        getAllBuyCoursesRs.getString("course_short_id"),
						        getAllBuyCoursesRs.getString("sub_course_Name")
						    )
						);
				}
			}
		}catch(Exception e) {
			message_error="Server error Try again";
			e.printStackTrace();
		 }	
		if(message_error!=null) {
			courseContent =new BuyCourseOpenInformationGetModel(null, null, null, null, message_error);
		}else {
			courseContent =new BuyCourseOpenInformationGetModel(null, null, subCourseRelative, sub_course_name, null);	
		}
		return courseContent;
	}
}
