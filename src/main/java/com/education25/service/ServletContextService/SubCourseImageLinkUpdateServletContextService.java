package com.education25.service.ServletContextService;

import javax.servlet.http.HttpServletRequest;

public interface SubCourseImageLinkUpdateServletContextService {
	boolean updateLink(HttpServletRequest request, int course_id, int Sub_course_id, String image_link);
}