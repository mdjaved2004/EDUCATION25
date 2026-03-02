package com.education25.service.adminService.coursesControlService;

import java.util.List;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;

public class CousesVerifyServiceImpl implements CousesVerifyService {

	@Override
	public int courseId(List<CoursesInformationGetModel> coursesInfo, String course_name) {
		int course_id = 0;
		try {
			for(CoursesInformationGetModel course : coursesInfo) {
				if(course.getCourse_name().equalsIgnoreCase(course_name)) {
					course_id=course.getCourse_id();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			course_id = 0;
		}
		
		return course_id;
	}



	@Override
	public String checkCourseNameAndCourseId(List<CoursesInformationGetModel> coursesInfo, String course_name, int course_id) {
		String message_error ="Course Not Found";
		try {
			for(CoursesInformationGetModel course : coursesInfo) {
				if(course.getCourse_name().equalsIgnoreCase(course_name) && course.getCourse_id() == course_id) {
					message_error =null;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			course_id=0;
		}
		
		return message_error;
	}
}