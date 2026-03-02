package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.userModel.coursesModel.SubCourseAndSubCourseSortIdWithMessageModel;
import com.education25.service.userService.coursesService.Education25CourseOpenMainService;
import com.education25.service.userService.coursesService.Education25CourseOpenMainServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/education25-course-open-main")
public class Education25CourseOpenMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name=null, course_id=null, pageRedirect=null;
		
		course_name = request.getParameter("course_name");
		course_id = request.getParameter("course_id");	
		
		if(course_name==null || course_id==null) {
			request.setAttribute("message_error", "inactivity , Please Try Again");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		Education25CourseOpenMainService getFirstFreeSubCourseService =new Education25CourseOpenMainServiceImpl();
		
		SubCourseAndSubCourseSortIdWithMessageModel subCourseInfoService = getFirstFreeSubCourseService.getSubCourseInfoService(course_name, course_id);
		
		if(subCourseInfoService.getMessage_error()!=null) {
			request.setAttribute("message_error", subCourseInfoService.getMessage_error());
			pageRedirect = "/index.jsp";			
		}else {
			request.setAttribute("course_name", course_name);
			request.setAttribute("course_id", course_id);
			request.setAttribute("sub_course_name", subCourseInfoService.getSub_course_name());
			request.setAttribute("sub_course_sort_id", subCourseInfoService.getSub_course_sort_id());
			request.setAttribute("price", "0");
			pageRedirect = "/viewPages/user-view-pages/courses-view-pages/education25-course-open-data";
		}		
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;
	}
}