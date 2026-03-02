package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.MyCourseFreeCourseDeleteDao;
import com.education25.dao.userDao.coursesDao.MyCourseFreeCourseDeleteDaoImpl;

public class MyCourseFreeCourseDeleteServiceImpl implements MyCourseFreeCourseDeleteService {

	@Override
	public String removeSubCourseInMycourseService(String sub_course_sort_id, int user_id) {
		int sub_course_sort_id_int =0;
		try {
			sub_course_sort_id_int = Integer.parseInt(sub_course_sort_id);
		} catch (NumberFormatException e) {
			return "Information is Not valid . try again";
		}
		MyCourseFreeCourseDeleteDao dao=new MyCourseFreeCourseDeleteDaoImpl();
		
		return dao.removeSubCourseInMycourseDao(sub_course_sort_id_int , user_id);
	}
}