package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.BuyCourseDetailsDao;
import com.education25.dao.userDao.coursesDao.BuyCourseDetailsDaoImpl;
import com.education25.model.userModel.coursesModel.BuyCourseDetailsModel;

public class BuyCourseDetailsServiceImpl implements BuyCourseDetailsService {

	@Override
	public BuyCourseDetailsModel buyCourseService(String subCourseShortId, int user_id) {
		int shortId =0;
		shortId = validation(subCourseShortId);
		if(shortId==0) {
			return new BuyCourseDetailsModel(null, null, null, null, null, null, null, null, "Validation Failed Try again");
		}
		BuyCourseDetailsDao dao= new BuyCourseDetailsDaoImpl();
		
		return dao.buyCourseDao(shortId, user_id);
	}
	
	private int validation(String subCourseShortId) {
		int shortId =0;
		try {
			shortId = Integer.parseInt(subCourseShortId);
		} catch (NumberFormatException e) {
			shortId = 0;
			e.printStackTrace();
		}	
		return shortId;	
	}
}