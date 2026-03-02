package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentSubjectDeleteDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentSubjectDeleteModel;

public class SubCourseContentSubjectDeleteServiceImpl implements SubCourseContentSubjectDeleteService {

	@Override
	public String subCourseDeleteService(SubCourseContentSubjectDeleteModel model) {	
		return new SubCourseContentSubjectDeleteDaoImpl().subCourseDeleteDao(model);
	}
}