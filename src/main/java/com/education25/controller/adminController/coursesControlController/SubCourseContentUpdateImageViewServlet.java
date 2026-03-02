package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageGetInformationModel;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateImageViewService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateImageViewServiceImpl;


@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-update-image-view")
public class SubCourseContentUpdateImageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_course_short_id=null;
		
		sub_course_short_id= (String) request.getAttribute("sub_course_short_id");
		
		SubCourseContentUpdateImageViewService service = new SubCourseContentUpdateImageViewServiceImpl();
		 
		SubCourseImageGetInformationModel subcourseInformationService = service.getSubcourseImageLinkService(sub_course_short_id);
		
		request.setAttribute("image_link", subcourseInformationService.getImage_link());
		request.setAttribute("price", subcourseInformationService.getPrice());
		request.setAttribute("learning_days", subcourseInformationService.getLearning_days());
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-add-image.jsp");
		rd.forward(request, response);
		return;
	}

}