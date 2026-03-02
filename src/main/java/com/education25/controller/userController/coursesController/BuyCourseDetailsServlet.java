package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.coursesModel.BuyCourseDetailsModel;
import com.education25.service.userService.coursesService.BuyCourseDetailsService;
import com.education25.service.userService.coursesService.BuyCourseDetailsServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;
 
@WebServlet("/viewPages/user-view-pages/courses-view-pages/buy-course-details")
public class BuyCourseDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String message_error = null, sub_course_sort_id=null;
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
        
        sub_course_sort_id = request.getParameter("sub_cour_sort_id");
        
        if(sub_course_sort_id == null) {
        		message_error = "Valid information Not Find , Please try agin";
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
        }
        
        BuyCourseDetailsService service = new BuyCourseDetailsServiceImpl();
        BuyCourseDetailsModel buyCourseService = service.buyCourseService(sub_course_sort_id, user_id);
        
        if(buyCourseService.getError_message()!=null) {
        		request.setAttribute("message_error", buyCourseService.getError_message());
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
        }else {
    			request.setAttribute("course_name", buyCourseService.getCourseName());
    			request.setAttribute("course_id", buyCourseService.getCourseId());
    			request.setAttribute("sub_course_name", buyCourseService.getSubCourseName());
    			request.setAttribute("sub_course_id", buyCourseService.getSubCourseId());
    			request.setAttribute("price", buyCourseService.getPrice());
    			request.setAttribute("image_link", buyCourseService.getImageLink());
    			request.setAttribute("sortId", buyCourseService.getSortId());
    		
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/buy-course-details.jsp");
    			rd.forward(request, response);
    			return;
        }      
    }
}