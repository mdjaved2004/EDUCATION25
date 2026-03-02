package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseHeadingUpdateModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateHeadingService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateHeadingServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-heading")
public class SubCourseContentUpdateHeadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_course_name=null, sub_course_short_id=null,
				heading_id=null, heading_text=null, message_error=null;
		System.out.println("\n\nTask 03");
		sub_course_name = (String) request.getAttribute("sub_course_name");
		System.out.println("Task 04");
		sub_course_short_id=(String) request.getAttribute("sub_course_short_id");
		System.out.println("Task 05");
		heading_id =request.getParameter("heading_id");
		System.out.println("Task 06");
		heading_text =request.getParameter("heading_text_"+heading_id);
		System.out.println("task1230");
		if(heading_id==null) {
			message_error="Try again because not find valid information";
		}else if(heading_text==null) {
			message_error="Heading text is empty, Fist fill heading then click update";
		}
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
			rd.forward(request, response);
			return;
		}
		
		//Hold value in model class.
		SubCourseHeadingUpdateModel subCourseHeadingUpdateModel =new SubCourseHeadingUpdateModel(heading_id, sub_course_name, sub_course_short_id, heading_text, null);
		
		SubCourseContentUpdateHeadingService ServiceForHeadingUpdate = new SubCourseContentUpdateHeadingServiceImpl();
		
		message_error  = ServiceForHeadingUpdate.updateHeadingService(subCourseHeadingUpdateModel);
		
		
		if(message_error==null) {
			request.setAttribute("message", "Heading "+heading_id+" succesfull updated ");
		}else {
			request.setAttribute("message_error", message_error);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
		rd.forward(request, response);
		return;
	}
}