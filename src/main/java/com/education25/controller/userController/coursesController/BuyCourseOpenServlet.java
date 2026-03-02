package com.education25.controller.userController.coursesController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.coursesModel.BuyCourseOpenInformationGetModel;
import com.education25.service.userService.coursesService.BuyCourseOpenService;
import com.education25.service.userService.coursesService.BuyCourseOpenServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/paid-course-open")
public class BuyCourseOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String sub_course_sort_id=null, message_error;
		int user_id =0;
	    
	    	HttpSession session = request.getSession();
	    user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
	    if(user_id <= 0) {
			message_error = "You Are Not Login , Please Login First";
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
		rd.forward(request, response);
		return;
		}
	
		sub_course_sort_id = request.getParameter("sub_course_sort_id");

		if(sub_course_sort_id==null) {
			message_error = "Invalid Information, Try Again";
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}

		//Get Course Content Information  		
		BuyCourseOpenService  getInfoService = new BuyCourseOpenServiceImpl();
				
		BuyCourseOpenInformationGetModel buyCourseOpenInformationService = getInfoService.buyCourseOpenInformationService(user_id, sub_course_sort_id);
		
		if(buyCourseOpenInformationService.getMessage_error()!=null) {
			request.setAttribute("message_error", buyCourseOpenInformationService.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}else {
			request.setAttribute("sub_course_name", buyCourseOpenInformationService.getSub_course_name());
		    request.setAttribute("sub_course_sort_id", sub_course_sort_id);
		    
		    request.setAttribute("SubCourseHeading", buyCourseOpenInformationService.getSubCourseHeading());
			request.setAttribute("SubCourseSubHeading", buyCourseOpenInformationService.getSubCourseSubHeading());
    			request.setAttribute("SubCourseRelative", buyCourseOpenInformationService.getSubCourseRelative());

			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/buy-course-open.jsp");
			rd.forward(request, response);
			return;
		}
	}
}