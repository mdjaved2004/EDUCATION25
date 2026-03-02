package com.education25.service.adminService.coursesControlService;

import java.util.List;
import java.util.Map;
import com.education25.dao.adminDao.coursesControlDao.SubCourseInsertDataDaoImpl;
import com.education25.model.adminModel.coursesControlModel.CourseAndSubCourseWithMessageInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.model.adminModel.coursesControlModel.SubHeadingContentModel;

public class SubCourseInsertDataServiceImpl implements SubCourseInsertDataService {

	@Override
	public CourseAndSubCourseWithMessageInfoModel subCourseInsertDataService(int adminId, SubCourseAddNewFormModel SubcourseFormModel,
			Map<String, List<SubHeadingContentModel>> subCourseContent) {
		
		return new SubCourseInsertDataDaoImpl().subCourseInsertDataDao(adminId, SubcourseFormModel, subCourseContent);
		
	}
}