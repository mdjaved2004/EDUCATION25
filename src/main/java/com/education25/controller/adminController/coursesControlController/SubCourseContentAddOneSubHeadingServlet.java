package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneSubHeadingFormModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentAddOneSubHeadingService;
import com.education25.service.adminService.coursesControlService.SubCourseContentAddOneSubHeadingServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-one-sub-heading")
public class SubCourseContentAddOneSubHeadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String course_name=null, heading_id=null, sub_course_name=null,
				sub_course_short_id=null, message_error=null, message=null;
		String sub_heading_id=null, sub_heading_text=null,sub_heading_definition=null,sub_heading_example=null;
		
		heading_id = request.getParameter("heading_id");
		course_name = request.getParameter("course_name");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_short_id = request.getParameter("sub_course_short_id");
		
		sub_heading_id = request.getParameter("sub_heading_id");
		sub_heading_text = request.getParameter("new_sub_heading_text");
		sub_heading_definition = request.getParameter("new_sub_heading_defination_text");
		sub_heading_example = request.getParameter("new_sub_heading_example_text");
		
		if(heading_id==null || sub_course_name==null || sub_course_short_id==null) {
			message_error= "Try again because not find valid information";
		}else if(sub_heading_text==null) {
			message_error ="New Heading bopx is empty, Please fill information";
		}
		
		if(message_error!=null) {			
			request.setAttribute("message_error",message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data");
			rd.forward(request, response);
			return;
		}
		
		//Hold value in model class		
		SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel = new SubCourseContentAddOneSubHeadingFormModel(heading_id, sub_heading_id, sub_course_name, sub_course_short_id, sub_heading_text, sub_heading_definition, sub_heading_example, message_error);
		
		SubCourseContentAddOneSubHeadingService serviceAddSubHeading= new SubCourseContentAddOneSubHeadingServiceImpl(); 
			
		message_error = serviceAddSubHeading.addOneSubHeadingService(subHeadingFormModel);
		
		if(message_error==null) {
			message = "Sub Heading succesfull added in Heading "+heading_id+".";		
		}
		
		String redirectData =(message != null ? "message=" + URLEncoder.encode(message, "UTF-8") : "message_error=" + URLEncoder.encode(message_error, "UTF-8"))
				+ "&id=" + URLEncoder.encode("update", "UTF-8")
			    + "&course_name=" + URLEncoder.encode(course_name, "UTF-8")
			    + "&sub_course_name=" + URLEncoder.encode(sub_course_name, "UTF-8");
		
		response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-view"
			    + "?" + redirectData);
	    }
	}