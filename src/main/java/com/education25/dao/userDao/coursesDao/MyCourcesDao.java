package com.education25.dao.userDao.coursesDao;

import java.sql.Connection;
import java.util.List;
import com.education25.model.userModel.coursesModel.MyCoursesFreeSubCoursesModel;
import com.education25.model.userModel.coursesModel.MyCoursesPaidSubCoursesModel;
import com.education25.model.userModel.coursesModel.MyCoursesReturnModel;

public interface MyCourcesDao {
	MyCoursesReturnModel getMyCoursesMain(int user_id);
	List<MyCoursesPaidSubCoursesModel> getPaidCourses(Connection con, int user_id);
	List<MyCoursesFreeSubCoursesModel> getFreeCourses(Connection con, int user_id);
	List<MyCoursesFreeSubCoursesModel> getBuyCoursesSuggestion(Connection con);	
}