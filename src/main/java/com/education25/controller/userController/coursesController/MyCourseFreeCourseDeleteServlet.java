package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.userService.coursesService.MyCourseFreeCourseDeleteService;
import com.education25.service.userService.coursesService.MyCourseFreeCourseDeleteServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/free-course-delete")
public class MyCourseFreeCourseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sub_course_sort_id = null, message_error=null;
        int user_id=0;
        
        HttpSession session = request.getSession();
        user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
        if(user_id == 0) {
    			message_error = "You Are Not Login , Please Login First";
    			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
    		}
        
        sub_course_sort_id = request.getParameter("sub_course_sort_id");
        
        if(sub_course_sort_id==null) {
			message_error = "Information is Not valid . try again";
			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/my-courses");
			rd.forward(request, response);
			return;
		}
        
        //Service for remove free sub-course in MyCourse.
        MyCourseFreeCourseDeleteService service=new MyCourseFreeCourseDeleteServiceImpl();
        message_error =service.removeSubCourseInMycourseService(sub_course_sort_id, user_id);
       
        if(message_error!=null) {
			request.setAttribute("message_error", message_error);
        }else {
            request.setAttribute("message", "Course deleted successfull");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/my-courses");
		rd.forward(request, response);
		return;
    }
}