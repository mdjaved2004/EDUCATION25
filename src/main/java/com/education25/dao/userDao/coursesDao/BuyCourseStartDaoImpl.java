package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;

public class BuyCourseStartDaoImpl implements BuyCourseStartDao {

	@Override
	public String checkCoursesAlreadyBuyAndAmoutDao(int user_id, int amount, String subCourseSortId) {
		String message_error=null;
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();) {
			con.setAutoCommit(false);
			message_error = checkCourseBuyAndAmount(con, subCourseSortId, user_id, amount);			
			con.commit();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return message_error;
	}
	
	private String checkCourseBuyAndAmount(Connection con, String subCourseSortId, int user_id, int amount) {
		String message_error = null;
		String checkCourseAlreadyBuyOrNot = "SELECT buy_course_date FROM buy_courses WHERE user_id = ? AND  course_short_id = ?";
		String checkCourseAmount = "SELECT price FROM sub_courses WHERE sort_id = ? ";
		try(PreparedStatement psForCheck=con.prepareStatement(checkCourseAlreadyBuyOrNot);
			PreparedStatement amountCheck=con.prepareStatement(checkCourseAmount)) {
			
			psForCheck.setInt(1, user_id);
			psForCheck.setInt(2, Integer.parseInt(subCourseSortId));
			ResultSet rsForCheck = psForCheck.executeQuery();
			if(rsForCheck.next()) {
				message_error = "THis course Already buy in " + rsForCheck.getDate("buy_course_date");
			}else {
				amountCheck.setInt(1, Integer.parseInt(subCourseSortId));
				ResultSet rsAmount = amountCheck.executeQuery();
				if(rsAmount.next()) {
					if(amount != rsAmount.getInt("price")) {
						 message_error = "Invalid payment amount detected. Possible unauthorized activity.";
					}
				}
			}
			
		}catch(Exception e) {
			message_error = "Server error, please Try agin";
			e.printStackTrace();
		}
			 
		return message_error;
	}
}