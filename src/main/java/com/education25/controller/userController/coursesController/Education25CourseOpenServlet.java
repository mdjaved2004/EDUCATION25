package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.userModel.coursesModel.SubCourseInformationGetModel;
import com.education25.model.userModel.coursesModel.SubCourseOpenFormDataHoldModel;
import com.education25.model.userModel.coursesModel.SubCourseRelativeCourseInformationGetModel;
import com.education25.service.userService.coursesService.Education25CourseOpenService;
import com.education25.service.userService.coursesService.Education25CourseOpenServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/education25-course-open-data")
public class Education25CourseOpenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String course_name=null, course_id=null, sub_course_name=null, sub_course_sort_id=null, price=null;
    		String message_error =null;
    		
    		course_name =(String) request.getAttribute("course_name");
    		course_id = (String) request.getAttribute("course_id");
    		sub_course_name = (String) request.getAttribute("sub_course_name");
    		sub_course_sort_id = (String) request.getAttribute("sub_course_sort_id");
    		price = (String) request.getAttribute("price");
    		
    		if(price==null) {
    			message_error = "Some information is inactive. Please try again.";
    		}else if(Integer.parseInt(price)!=0) {
    			message_error = "This Course Is Paid, First In Buy Then Open";
    		}else if(course_name==null || course_id==null || sub_course_name==null || sub_course_sort_id==null) {
    			message_error = "Invalid Information, Try Again";
    		}
    		
    		if(message_error!=null) {
    			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
    		}
    		
    		//Hold Value In Model Class.		
    		SubCourseOpenFormDataHoldModel subCourseOpenFormDataHoldModel = new SubCourseOpenFormDataHoldModel(course_name, course_id, sub_course_name, sub_course_sort_id, price);
    		
    		//Get Course Content Information  		
    		Education25CourseOpenService  getInfoService = new Education25CourseOpenServiceImpl();
    		SubCourseInformationGetModel subCourseInformationService = getInfoService.subCourseInformationService(subCourseOpenFormDataHoldModel);
    		
    		 if(subCourseInformationService.getMessage_error()!=null) {
 	    		request.setAttribute("message_error", subCourseInformationService.getMessage_error());
 			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
 			rd.forward(request, response);
 			return;
    		 }
    		 
    	    request.setAttribute("course_name", course_name);
    	    request.setAttribute("course_id", course_id);
    	    request.setAttribute("sub_course_name", sub_course_name);
    	    request.setAttribute("sub_course_sort_id", sub_course_sort_id);
    	    request.setAttribute("price", price);
    	  
    		request.setAttribute("SubCourseHeading", subCourseInformationService.getSubCourseHeading());
    		request.setAttribute("SubCourseSubHeading", subCourseInformationService.getSubCourseSubHeading());
    		request.setAttribute("SubCourseRelative", subCourseInformationService.getSubCourseRelative());
	    RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/courses-view-pages/education25-course-open.jsp");
		rd.forward(request, response);
		return; 	    	    
    }
}