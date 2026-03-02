package com.education25.eventHandler;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import com.education25.dao.ServletContextDao.CoursesInformationGetDao;
import com.education25.dao.ServletContextDao.CoursesInformationGetDaoImpl;
import com.education25.dao.ServletContextDao.OnlineExamInformationGetDaoImpl;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.OnlineExamContextModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class StartServletContextSet {
	
	public boolean setServleteContext(ServletContextEvent sce) {
		try {
			List<CoursesInformationGetModel> coursesInformationDao=null;
			Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesDao=null;
			List<OnlineExamContextModel> onlineExamContext=null;
			
			//Get global ServletContext
			ServletContext context = sce.getServletContext();
			
			// Load dynamic data from service layer
			CoursesInformationGetDao coursesInformationGetDao = new CoursesInformationGetDaoImpl();
			
			//Get courses information;
			coursesInformationDao = coursesInformationGetDao.coursesInformationDao();
			
			//Get courses and sub-course information. 
			coursesAndSubCoursesDao= coursesInformationGetDao.coursesAndSubCoursesDao();
			
			//Get OnlineExamContext
			onlineExamContext = new OnlineExamInformationGetDaoImpl().getOnlineExamContext();
			
			//Store data in ServletContext (available for all JSPs & Servlets)
			context.setAttribute("coursesList", coursesInformationDao);
			context.setAttribute("coursesAndSubCoursesMap", coursesAndSubCoursesDao);
			context.setAttribute("onlineExamContext", onlineExamContext);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;	
	}
}