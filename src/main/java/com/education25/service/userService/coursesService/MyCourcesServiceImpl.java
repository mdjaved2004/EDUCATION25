package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.MyCourcesDaoImpl;
import com.education25.model.userModel.coursesModel.MyCoursesReturnModel;

public class MyCourcesServiceImpl implements MyCourcesService {

	@Override
	public MyCoursesReturnModel getMyCoursesInformation(int user_id) {
		
		MyCoursesReturnModel myCourses = new MyCourcesDaoImpl().getMyCoursesMain(user_id);
				
		return myCourses;
	}
}