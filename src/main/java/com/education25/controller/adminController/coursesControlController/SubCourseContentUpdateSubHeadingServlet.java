package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseSubHeadingUpdateModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateSubHeadingService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateSubHeadingServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-sub-heading")
public class SubCourseContentUpdateSubHeadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_course_name=null, sub_course_short_id=null, heading_id=null, message_error=null;
		String sub_heading_id=null, sub_heading_text=null,sub_heading_definition=null, sub_heading_example=null;
		
		sub_course_name = (String) request.getAttribute("sub_course_name");
		sub_course_short_id=(String) request.getAttribute("sub_course_short_id");
		heading_id = request.getParameter("heading_id");
		sub_heading_id = request.getParameter("sub_heading_id");
		
		if(sub_heading_id!=null) {
			sub_heading_text = request.getParameter("sub_heading_text_"+sub_heading_id);
			sub_heading_definition = request.getParameter("sub_heading_definition_"+sub_heading_id);
			sub_heading_example = request.getParameter("sub_heading_example_"+sub_heading_id);		
		}else {
			request.setAttribute("message_error", "Try again because not find valid information");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
			rd.forward(request, response);
			return;
		}
		
		//Hold value in model class.
		SubCourseSubHeadingUpdateModel subCourseHeadingUpdateModel =new SubCourseSubHeadingUpdateModel(heading_id, sub_course_name, sub_course_short_id, sub_heading_id, sub_heading_text, sub_heading_definition, sub_heading_example, null);
		
		SubCourseContentUpdateSubHeadingService ServiceForHeadingUpdate = new SubCourseContentUpdateSubHeadingServiceImpl();
		
		message_error  = ServiceForHeadingUpdate.updateSubHeadingService(subCourseHeadingUpdateModel);
		
		if(message_error==null) {
			request.setAttribute("message", "Sub Heading in Heading "+heading_id+" has been updated successfully.");
		}else {
			request.setAttribute("message_error", message_error);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
		rd.forward(request, response);
		return;
	}
}