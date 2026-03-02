package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentRemoveOneSubHeadingModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentRemoveOneSubHeadingService;
import com.education25.service.adminService.coursesControlService.SubCourseContentRemoveOneSubHeadingServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-remove-one-sub-heading")
public class SubCourseContentRemoveOneSubHeadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name=null, heading_id=null, sub_course_name=null,
				sub_course_short_id=null, message_error=null, message=null;
		String sub_heading_id=null;
		
		heading_id = request.getParameter("heading_id");
		course_name = request.getParameter("course_name");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_short_id = request.getParameter("sub_course_short_id");
		
		sub_heading_id = request.getParameter("sub_heading_id");
		
		if(heading_id==null || sub_heading_id==null || sub_course_name==null || sub_course_short_id==null) {
			message_error= "Try again because not find valid information";
		}
		
		if(message_error!=null) {			
			request.setAttribute("message_error",message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
			rd.forward(request, response);
			return;
		}
		
		//Hold value in model class		
		SubCourseContentRemoveOneSubHeadingModel removeOneSubHeadingModel = new SubCourseContentRemoveOneSubHeadingModel(heading_id, sub_heading_id, sub_course_name, sub_course_short_id, message_error);

		SubCourseContentRemoveOneSubHeadingService removeOneSubHeadingservice= new SubCourseContentRemoveOneSubHeadingServiceImpl(); 
				
		message_error = removeOneSubHeadingservice.removeOneSubHeadingService(removeOneSubHeadingModel);
		
		if(message_error==null) {
			message = "Sub Heading removed succesfull in Heading "+heading_id+".";		
		}
		
		String redirectData =(message != null ? "message=" + URLEncoder.encode(message, "UTF-8") : "message_error=" + URLEncoder.encode(message_error, "UTF-8"))
				+ "&id=" + URLEncoder.encode("update", "UTF-8")
			    + "&course_name=" + URLEncoder.encode(course_name, "UTF-8")
			    + "&sub_course_name=" + URLEncoder.encode(sub_course_name, "UTF-8");
		
		response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-view"
			    + "?" + redirectData);			
	}
}