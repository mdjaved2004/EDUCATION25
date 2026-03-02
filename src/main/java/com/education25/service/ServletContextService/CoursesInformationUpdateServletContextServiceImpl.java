package com.education25.service.ServletContextService;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.education25.dao.ServletContextDao.CoursesInformationGetDao;
import com.education25.dao.ServletContextDao.CoursesInformationGetDaoImpl;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class CoursesInformationUpdateServletContextServiceImpl implements CoursesInformationUpdateServletContextService {
	
	@Override
	public boolean courseContentSetInServleteContext(HttpServletRequest request) {
		try {
			List<CoursesInformationGetModel> coursesInformationDao=null;
			Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesDao=null;
			
			//Get global ServletContext
			ServletContext context = request.getServletContext();
			
			// Load dynamic data from service layer
			CoursesInformationGetDao coursesInformationGetDao = new CoursesInformationGetDaoImpl();
			
			//Get courses information;
			coursesInformationDao = coursesInformationGetDao.coursesInformationDao();
			
			//Get courses and sub-course information. 
			coursesAndSubCoursesDao= coursesInformationGetDao.coursesAndSubCoursesDao();
			
			
			//Store data in ServletContext (available for all JSPs & Servlets)
			context.setAttribute("coursesList", coursesInformationDao);
			context.setAttribute("coursesAndSubCoursesMap", coursesAndSubCoursesDao);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
}