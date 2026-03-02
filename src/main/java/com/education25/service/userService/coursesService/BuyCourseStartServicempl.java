package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.BuyCourseStartDao;
import com.education25.dao.userDao.coursesDao.BuyCourseStartDaoImpl;

public class BuyCourseStartServicempl implements BuyCourseStartService {

	@Override
	public String checkCoursesAlreadyBuyAndAmoutService(int user_id, int amount, String subCourseSortId) {
		BuyCourseStartDao dao=new BuyCourseStartDaoImpl();
		return dao.checkCoursesAlreadyBuyAndAmoutDao(user_id, amount, subCourseSortId);
	}
}