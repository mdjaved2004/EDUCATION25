package com.education25.dao.userDao.coursesDao;

public interface BuyCourseStartDao {
	String checkCoursesAlreadyBuyAndAmoutDao(int user_id, int amount, String subCourseSortId);
}