package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.PaymentRequestModel;

public class AfterSuccesPamentBuyCourseDaoImpl implements AfterSuccesPamentBuyCourseDao {

	@Override
	public String saveInformationDao(PaymentRequestModel model) {
		String message_error=null;
		String buy_course_data_insert = "INSERT INTO buy_courses (user_id , course_short_id, order_id, razorpay_payment_id, razorpay_signature, amount, payment_success, buy_course_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		  
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
			   PreparedStatement insert_data = con.prepareStatement(buy_course_data_insert);) {
				LocalDate today = LocalDate.now();
				
		        insert_data.setInt(1, model.getUserId());
		        insert_data.setInt(2, model.getSubCourseSortId());
		        insert_data.setString(3, model.getOrderId());
		        insert_data.setString(4, model.getPaymentId());
		        insert_data.setString(5, model.getSignature());
		        insert_data.setInt(6, model.getAmount());
		        insert_data.setBoolean(7, true);
		        insert_data.setString(8, today.toString());
		        insert_data.executeUpdate();
		  } catch (Exception e) {
			  message_error="Payment succesfull tranfer but server error this time wait some time";
		      e.printStackTrace();
		  }
		return message_error;
	}
}