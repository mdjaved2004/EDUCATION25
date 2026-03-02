package com.education25.service.userService.coursesService;

import com.education25.model.userModel.coursesModel.BuyCourseOpenInformationGetModel;

public interface BuyCourseOpenService {
	BuyCourseOpenInformationGetModel buyCourseOpenInformationService(int user_id, String sub_course_sort_id);
}
