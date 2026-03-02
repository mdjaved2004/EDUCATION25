package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateImageViewDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageGetInformationModel;

public class SubCourseContentUpdateImageViewServiceImpl implements SubCourseContentUpdateImageViewService {

	@Override
	public SubCourseImageGetInformationModel getSubcourseImageLinkService(String sub_course_short_id) {
		return new SubCourseContentUpdateImageViewDaoImpl().getSubcourseImageLinkService(sub_course_short_id);
	}
}