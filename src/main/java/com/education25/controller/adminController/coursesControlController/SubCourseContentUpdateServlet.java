package com.education25.controller.adminController.coursesControlController;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update")
public class SubCourseContentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name=null, course_id=null, sub_course_name=null, sub_course_short_id=null;
		String form_id=null, redirect_page=null;
		boolean verifyAdmin=false;
		
		HttpSession session = request.getSession();
		
		//Verify this person are admin are not admin  and return true or false.
		verifyAdmin=new AdminVerifyServiceImpl().adminVerifyBoolean(session);
		if(!verifyAdmin) {
			request.setAttribute("message_error", "You are not login, Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		form_id=request.getParameter("form_id");
		course_name = request.getParameter("course_name");
		course_id = request.getParameter("course_id");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_short_id = request.getParameter("sub_course_short_id");
		
		if(course_name==null || course_id==null || sub_course_name==null || sub_course_short_id==null || form_id==null) {
			request.setAttribute("message_error", "Try again because not find valid information");
			RequestDispatcher rd = request.getRequestDispatcher(redirect_page);
			rd.forward(request, response);
			return;
		}
		request.setAttribute("course_name", course_name);
		request.setAttribute("course_id", course_id);
		request.setAttribute("sub_course_name", sub_course_name);
		request.setAttribute("sub_course_short_id", sub_course_short_id);
		switch (form_id) {
		    case "heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-heading";
		        break;
	
		    case "sub-heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-sub-heading";
		        break;
		        
		    case "add-one-heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-one-heading";
		        break;
		        
		    case "add-one-sub-heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-one-sub-heading";
		        break;
		        
		    case "remove-one-sub-heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-remove-one-sub-heading";
		        break;
		      
		    case "remove-one-heading":
		        redirect_page ="/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-remove-one-heading";
		        break;
	
		    default: request.setAttribute("message_error", "Please do not change any default information");
		        redirect_page = "/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp";
		        break;
		}

		
		RequestDispatcher rd = request.getRequestDispatcher(redirect_page);
		rd.forward(request, response);
		return;
	    		    	
	 }

}
