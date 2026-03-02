package com.education25.dao.userDao.coursesDao;

import com.education25.model.userModel.coursesModel.BuyCourseOpenInformationGetModel;

public interface BuyCourseOpenDao {
	BuyCourseOpenInformationGetModel buyCourseOpenInformationDao(int user_id, String sub_course_sort_id);
}
