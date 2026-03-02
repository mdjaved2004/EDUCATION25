package com.education25.dao.userDao.coursesDao;

import com.education25.model.userModel.coursesModel.SubCourseAndSubCourseSortIdWithMessageModel;

public interface Education25CourseOpenMainDao {
	SubCourseAndSubCourseSortIdWithMessageModel getSubCourseInfoDao(String course_name, String course_id);
}