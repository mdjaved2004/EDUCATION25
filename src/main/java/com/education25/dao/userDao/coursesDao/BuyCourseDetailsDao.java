package com.education25.dao.userDao.coursesDao;

import com.education25.model.userModel.coursesModel.BuyCourseDetailsModel;

public interface BuyCourseDetailsDao {
	BuyCourseDetailsModel buyCourseDao(int shortId, int user_id);
}