package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.coursesModel.MyCoursesReturnModel;
import com.education25.service.userService.coursesService.MyCourcesServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/my-courses")
public class MyCourcesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int user_id=0;
		String message_error=null;

		user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
		
		if(user_id == 0) {
			request.setAttribute(message_error, "You are not login, Please Login First");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;	
		}
		
		//Call service layer for get My courses information 
		MyCoursesReturnModel myCourses = new MyCourcesServiceImpl().getMyCoursesInformation(user_id);
		
		request.setAttribute("myCoursesPaid", myCourses.getPaidCourseList());
		request.setAttribute("myCoursesFree", myCourses.getFreeCourseList());
		request.setAttribute("myCoursesBuySuggestion", myCourses.getBuyCoursesSuggestion());
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/my-courses.jsp");
		rd.forward(request, response);
		return;		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
}