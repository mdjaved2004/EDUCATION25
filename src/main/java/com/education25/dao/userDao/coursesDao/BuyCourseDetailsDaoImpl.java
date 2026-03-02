package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.BuyCourseDetailsModel;

public class BuyCourseDetailsDaoImpl implements BuyCourseDetailsDao {

	@Override
	public BuyCourseDetailsModel buyCourseDao(int shortId, int user_id) {
		BuyCourseDetailsModel getbuyCourseDetailse=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			getbuyCourseDetailse = getbuyCourseDetailse(con, shortId, user_id);			
			con.commit();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return getbuyCourseDetailse;
	}
	
	private BuyCourseDetailsModel getbuyCourseDetailse(Connection con, int shortId, int user_id) {
		BuyCourseDetailsModel buyCourseDetails =null;
		String message_error = null;
		String checkCourseAlreadyBuyOrNot = "SELECT buy_course_date FROM buy_courses WHERE user_id = ? AND  course_short_id = ?";
		String buyCourseDetailsGetQuery="SELECT c.course_name, c.course_id, sc.sub_course_Id, sc.sub_course_Name, sc.learningDays, sc.price, "
				+ "sc.sort_id, sc.image_link FROM (SELECT * FROM sub_courses WHERE sort_id = ?) sc JOIN courses c ON sc.course_id = c.course_id";		
		
		try(PreparedStatement psForCheck=con.prepareStatement(checkCourseAlreadyBuyOrNot);
			PreparedStatement ps=con.prepareStatement(buyCourseDetailsGetQuery)) {
			
			psForCheck.setInt(1, user_id);
			psForCheck.setInt(2, shortId);
			ResultSet rsForCheck = psForCheck.executeQuery();
			if(rsForCheck.next()) {
				message_error = "This course Already buy in " + rsForCheck.getDate("buy_course_date") + ", Please click My Courses for Check";
				buyCourseDetails= new BuyCourseDetailsModel(null, null, null, null, null, null, null, null, message_error);
			}else {		
				ps.setInt(1, shortId);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					buyCourseDetails= new BuyCourseDetailsModel(rs.getString("course_name"), rs.getString("course_id"), rs.getString("sub_course_Id"), rs.getString("sub_course_Name"), rs.getString("learningDays"), rs.getString("price"), rs.getString("sort_id"), rs.getString("image_link"), null); 				
				}else {
					message_error = "This Course is Not Available , Try Again";
					buyCourseDetails= new BuyCourseDetailsModel(null, null, null, null, null, null, null, null, message_error);
				}
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
			 
		return buyCourseDetails;
	}
}