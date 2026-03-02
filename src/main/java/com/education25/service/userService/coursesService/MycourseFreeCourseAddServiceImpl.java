package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.MycourseFreeCourseAddDao;
import com.education25.dao.userDao.coursesDao.MycourseFreeCourseAddDaoImpl;

public class MycourseFreeCourseAddServiceImpl implements MycourseFreeCourseAddService {

	@Override
	public String addFreeCourseService(int sub_course_sort_id, int user_id) {
		MycourseFreeCourseAddDao daoForAddCourse =new  MycourseFreeCourseAddDaoImpl();
		return daoForAddCourse.addFreeCourseDao(sub_course_sort_id, user_id);
	}
}