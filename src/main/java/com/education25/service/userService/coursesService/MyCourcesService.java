package com.education25.service.userService.coursesService;

import com.education25.model.userModel.coursesModel.MyCoursesReturnModel;

public interface MyCourcesService {
	MyCoursesReturnModel getMyCoursesInformation(int user_id);
}