package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.BuyCourseOpenDao;
import com.education25.dao.userDao.coursesDao.BuyCourseOpenDaoImpl;
import com.education25.model.userModel.coursesModel.BuyCourseOpenInformationGetModel;

public class BuyCourseOpenServiceImpl implements BuyCourseOpenService {

	@Override
	public BuyCourseOpenInformationGetModel buyCourseOpenInformationService(int user_id, String sub_course_sort_id) {
		BuyCourseOpenDao getInfoDao= new BuyCourseOpenDaoImpl();
		return getInfoDao.buyCourseOpenInformationDao(user_id, sub_course_sort_id);
	}

}
