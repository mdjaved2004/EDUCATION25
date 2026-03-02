package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentRemoveOneHeadingDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentRemoveOneHeadingModel;

public class SubCourseContentRemoveOneHeadingServiceImpl implements SubCourseContentRemoveOneHeadingService {

	@Override
	public String removeOneHeadingService(SubCourseContentRemoveOneHeadingModel removeOneHeadingModel) {
		return new SubCourseContentRemoveOneHeadingDaoImpl().removeOneHeadingDao(removeOneHeadingModel);
	}
}