package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateFormDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCoursesContentListAndMessageModel;

public class SubCourseContentUpdateFormServiceImpl implements SubCourseContentUpdateFormService {

	@Override
	public SubCoursesContentListAndMessageModel getinformationBasedOnAdminService(int AdminId) {		
		return new SubCourseContentUpdateFormDaoImpl().getinformationBasedOnAdminDao(AdminId);	
	}
}