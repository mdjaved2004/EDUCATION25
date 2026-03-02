package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateViewDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentUpdateFormModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseMainContentModel;

public class SubCourseContentUpdateViewServiceImpl implements SubCourseContentUpdateViewService {

	@Override
	public SubCourseMainContentModel checkCourseAndSubCourseServoice(	SubCourseContentUpdateFormModel subCourseContentFormModel) {		
		return new SubCourseContentUpdateViewDaoImpl().checkCourseAndSubCourseDao(subCourseContentFormModel);
	}
}