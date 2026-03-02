package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.Education25CourseOpenDao;
import com.education25.dao.userDao.coursesDao.Education25CourseOpenDaoImpl;
import com.education25.model.userModel.coursesModel.SubCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseOpenFormDataHoldModel;

public class Education25CourseOpenServiceImpl implements Education25CourseOpenService {

	@Override
	public SubCourseInformationGetModel subCourseInformationService(SubCourseOpenFormDataHoldModel subCourseOpenFormDataHoldModel) {
		Education25CourseOpenDao getInfoDao= new Education25CourseOpenDaoImpl();
		return getInfoDao.subCourseInformationDao(subCourseOpenFormDataHoldModel);
	}
}