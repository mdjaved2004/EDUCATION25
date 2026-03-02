package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.Education25CourseOpenMainDao;
import com.education25.dao.userDao.coursesDao.Education25CourseOpenMainDaoImpl;
import com.education25.model.userModel.coursesModel.SubCourseAndSubCourseSortIdWithMessageModel;

public class Education25CourseOpenMainServiceImpl implements Education25CourseOpenMainService {

	@Override
	public SubCourseAndSubCourseSortIdWithMessageModel getSubCourseInfoService(String course_name, String course_id) {
		Education25CourseOpenMainDao getFirstFreeSubCourseDao =new Education25CourseOpenMainDaoImpl();		
		return getFirstFreeSubCourseDao.getSubCourseInfoDao(course_name, course_id);
	}
}