package com.education25.service.ServletContextService;

import javax.servlet.http.HttpServletRequest;

public interface DeleteOneSubCourseServletContextService {
	boolean  deleteOneSubCourse(HttpServletRequest request, int course_id, int suCourseShortId);
}
