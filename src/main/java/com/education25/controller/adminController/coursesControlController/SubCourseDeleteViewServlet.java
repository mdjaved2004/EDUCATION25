package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseFullInformationModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateDataService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateDataServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-delete-view")
public class SubCourseDeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId=null, subCourseName=null, sortId=null, pageRedirect=null;
		
		subCourseName = (String) request.getAttribute("sub_course_name");
		sortId = (String) request.getAttribute("sub_course_short_id");
		courseId =(String) request.getAttribute("course_id");

		SubCourseContentUpdateDataService service = new SubCourseContentUpdateDataServiceImpl();
	
		SubCourseFullInformationModel subCourseFullInformationModel = service.subCourseFullInformationService(subCourseName, sortId);
    
	    if(subCourseFullInformationModel.getMessage_error()!=null) {
	    		request.setAttribute("message_error", subCourseFullInformationModel.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp");
			rd.forward(request, response);
			return;
	    }else {
	    		request.setAttribute("SubCourseHeading", subCourseFullInformationModel.getSubCourseHeading());
	    		request.setAttribute("SubCourseSubHeading", subCourseFullInformationModel.getSubCourseSubHeading());
		    pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-show-before-deleted.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
			rd.forward(request, response);
			return; 	
		    }	    
	}
}