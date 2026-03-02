package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/education25-course-open")
public class Education25SubCourseOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name=null, course_id=null, sub_course_name=null, sub_course_sort_id=null, price=null;
		String message_error =null, pageRedirect=null;
		
		course_name =request.getParameter("course_name");
		course_id = request.getParameter("course_id");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_sort_id = request.getParameter("sub_course_sort_id");
		price = request.getParameter("price");
		
		if(course_name==null || course_id==null || sub_course_name==null || sub_course_sort_id==null) {
			message_error = "Invalid Information, Try Again";
		}
		
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
			pageRedirect = "/index.jsp";	
		}else{
			request.setAttribute("course_name", course_name);
			request.setAttribute("course_id", course_id);
			request.setAttribute("sub_course_name", sub_course_name);
			request.setAttribute("sub_course_sort_id", sub_course_sort_id);
			request.setAttribute("price", price);		
			pageRedirect = "/viewPages/user-view-pages/courses-view-pages/education25-course-open-data";
		}		
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;	
	}
}