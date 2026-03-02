package com.education25.service.ServletContextService;

import javax.servlet.http.HttpServletRequest;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public interface AddNewSubCourseServletContextService {
	boolean  addNewSubCourse(HttpServletRequest request, CoursesInformationGetModel course,SubCourseInformationModel subcourse);
}