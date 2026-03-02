package com.education25.service.adminService.coursesControlService;

import java.util.List;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;

public interface CousesVerifyService {
	int courseId(List<CoursesInformationGetModel> coursesInfo, String course_name);
	String checkCourseNameAndCourseId(List<CoursesInformationGetModel> coursesInfo, String course_name, int course_id );
}