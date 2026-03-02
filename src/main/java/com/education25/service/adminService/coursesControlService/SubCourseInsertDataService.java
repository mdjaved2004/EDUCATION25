package com.education25.service.adminService.coursesControlService;

import java.util.List;
import java.util.Map;
import com.education25.model.adminModel.coursesControlModel.CourseAndSubCourseWithMessageInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.model.adminModel.coursesControlModel.SubHeadingContentModel;

public interface SubCourseInsertDataService {
	CourseAndSubCourseWithMessageInfoModel subCourseInsertDataService(int adminId, SubCourseAddNewFormModel subcourseFormModel, Map<String, List<SubHeadingContentModel>> subCourseContent);
}