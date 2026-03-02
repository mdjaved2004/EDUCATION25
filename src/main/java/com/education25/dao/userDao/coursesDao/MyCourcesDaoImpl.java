package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.userModel.coursesModel.MyCoursesPaidSubCoursesModel;
import com.education25.model.userModel.coursesModel.MyCoursesReturnModel;
import com.education25.model.userModel.coursesModel.MyCoursesFreeSubCoursesModel;

public class MyCourcesDaoImpl implements MyCourcesDao{
	
	@Override
	public MyCoursesReturnModel getMyCoursesMain(int user_id) {
		List<MyCoursesPaidSubCoursesModel> paidList = new ArrayList<>();
	    List<MyCoursesFreeSubCoursesModel> freeList = new ArrayList<>();
	    List<MyCoursesFreeSubCoursesModel> suggestionList = new ArrayList<>();

	    try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo()) {

	        con.setAutoCommit(false);
	        paidList = getPaidCourses(con, user_id);
	        freeList = getFreeCourses(con, user_id);
	        suggestionList = getBuyCoursesSuggestion(con);

	        con.commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		    return new MyCoursesReturnModel(paidList, freeList, suggestionList);
	}
	
	@Override
	public List<MyCoursesPaidSubCoursesModel> getPaidCourses(Connection con, int user_id) {
	    List<MyCoursesPaidSubCoursesModel> list = new ArrayList<>();

	   String paid_course_query =
	    	    "SELECT sc.sub_course_Id, sc.sub_course_Name, sc.learningDays, sc.course_id, "
	    	  + "sc.price, sc.sort_id, sc.image_link, c.course_name "
	    	  + "FROM buy_courses bc "
	    	  + "JOIN sub_courses sc ON bc.course_short_id = sc.sort_id "
	    	  + "JOIN courses c ON sc.course_id = c.course_id "
	    	  + "WHERE bc.user_id = ? AND bc.payment_success = 1";


	    try (PreparedStatement ps = con.prepareStatement(paid_course_query)) {
	        ps.setInt(1, user_id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new MyCoursesPaidSubCoursesModel(
		                rs.getInt("sub_course_Id"),
		                rs.getString("sub_course_Name"),
		                rs.getString("learningDays"),
		                rs.getInt("price"),
		                rs.getString("sort_id"),
		                rs.getString("image_link"),
		                rs.getString("course_name"),
		                rs.getInt("course_id")
		               )
	            	);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	@Override
	public List<MyCoursesFreeSubCoursesModel> getFreeCourses(Connection con, int user_id) {

	    List<MyCoursesFreeSubCoursesModel> list = new ArrayList<>();

	    String free_course_query = "SELECT sc.sub_course_Id, sc.sub_course_Name, sc.learningDays, sc.price, "
	            + "sc.course_id, sc.sort_id, sc.image_link, c.course_name "
	            + "FROM add_free_courses a "
	            + "JOIN sub_courses sc ON sc.sort_id IN (a.course_1, a.course_2, a.course_3, a.course_4, a.course_5) "
	            + "JOIN courses c ON sc.course_id = c.course_id "
	            + "WHERE a.user_id = ? "
	            + "AND (a.course_1 != 0 OR a.course_2 != 0 OR a.course_3 != 0 OR a.course_4 != 0 OR a.course_5 != 0) "
	            + "LIMIT 5";

	    try (PreparedStatement ps = con.prepareStatement(free_course_query)) {
	        ps.setInt(1, user_id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new MyCoursesFreeSubCoursesModel(
	                rs.getInt("sub_course_Id"),
	                rs.getString("sub_course_Name"),
	                rs.getString("learningDays"),
	                rs.getInt("price"),
	                rs.getString("sort_id"),
	                rs.getString("image_link"),
	                rs.getInt("course_id"),
	                rs.getString("course_name")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	@Override
	public List<MyCoursesFreeSubCoursesModel> getBuyCoursesSuggestion(Connection con) {

	    List<MyCoursesFreeSubCoursesModel> list = new ArrayList<>();

	    String q = "SELECT sc.sub_course_Id, sc.sub_course_Name, sc.learningDays, sc.price, "
	            + "sc.sort_id, sc.course_id, sc.image_link, c.course_name "
	            + "FROM sub_courses sc " 
	            + "JOIN courses c ON sc.course_id = c.course_id "
	            + "WHERE sc.price > 0 LIMIT 15";

	    try (PreparedStatement ps = con.prepareStatement(q)) {
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new MyCoursesFreeSubCoursesModel(
	                rs.getInt("sub_course_Id"),
	                rs.getString("sub_course_Name"),
	                rs.getString("learningDays"),
	                rs.getInt("price"),
	                rs.getString("sort_id"),
	                rs.getString("image_link"),
	                rs.getInt("course_id"),
	                rs.getString("course_name")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}	
}