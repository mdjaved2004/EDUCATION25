package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import com.education25.model.adminModel.coursesControlModel.CourseAndSubCourseWithMessageInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseCreateEntityReturnBasicInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubHeadingContentModel;

public interface SubCourseInsertDataDao {
	CourseAndSubCourseWithMessageInfoModel subCourseInsertDataDao(int adminId, SubCourseAddNewFormModel SubcourseFormModel, Map<String, List<SubHeadingContentModel>> subCourseContent);
	SubCourseCreateEntityReturnBasicInfoModel CreateTableAndUpdateDataForInsertingData(int adminId, SubCourseAddNewFormModel SubcourseFormModel, Connection con);
	String subCourseContentInsert(SubCourseCreateEntityReturnBasicInfoModel SubCourseEntityInfo, Map<String, List<SubHeadingContentModel>> subCourseContent, Connection con);	
}