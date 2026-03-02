package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateDataDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseFullInformationModel;

public class SubCourseContentUpdateDataServiceImpl implements SubCourseContentUpdateDataService{
	@Override
	public SubCourseFullInformationModel subCourseFullInformationService(String subCourseName, String sortId) {
		return new SubCourseContentUpdateDataDaoImpl().subCourseContentUpdateDataDao(subCourseName, sortId);
	}
}