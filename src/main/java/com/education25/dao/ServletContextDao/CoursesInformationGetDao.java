package com.education25.dao.ServletContextDao;

import java.util.List;
import java.util.Map;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public interface CoursesInformationGetDao {
	
	public List<CoursesInformationGetModel> coursesInformationDao();
	
	public Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesDao();
}