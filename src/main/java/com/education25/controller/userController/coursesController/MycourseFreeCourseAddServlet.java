package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.userService.coursesService.MycourseFreeCourseAddService;
import com.education25.service.userService.coursesService.MycourseFreeCourseAddServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/free-course-add")
public class MycourseFreeCourseAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String course_name=null, course_id=null, sub_course_name=null, sub_course_sort_id=null, price=null;
		String message_error =null, pageRedirect=null;
		int user_id =0;
		
		HttpSession session = request.getSession();
		user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
    		
    		if(user_id == 0) {
    			message_error = "You Are Not Login , Please Login First";
    			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
    		}
		
		course_name = request.getParameter("course_name");
		course_id = request.getParameter("course_id");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_sort_id = request.getParameter("sub_course_sort_id");
		price = request.getParameter("price");
		
		if(price==null) {
			message_error = "Some information is inactive. Please try again.";
		}else if(price!=null) {
			if(Integer.parseInt(price)!=0) {
				message_error = "This Course Is Paid, Only Allow to buy";
			}
		}
		if(course_name==null || course_id==null || sub_course_name==null || sub_course_sort_id==null) {
			message_error = "Invalid Information, Try Again";
		}
		
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		return;
		}
 
		MycourseFreeCourseAddService serviceForAddCourse =new MycourseFreeCourseAddServiceImpl();
		message_error = serviceForAddCourse.addFreeCourseService(Integer.parseInt(sub_course_sort_id), user_id);
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
			pageRedirect="/index.jsp";
		}else {
			request.setAttribute("message", "Course Added Succesfully");
			pageRedirect = "/viewPages/user-view-pages/courses-view-pages/my-courses";
		}
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;
    }
}