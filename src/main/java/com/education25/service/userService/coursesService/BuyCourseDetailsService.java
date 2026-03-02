package com.education25.service.userService.coursesService;

import com.education25.model.userModel.coursesModel.BuyCourseDetailsModel;

public interface BuyCourseDetailsService {
	BuyCourseDetailsModel buyCourseService(String subCourseShortId, int user_id);
}