package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.adminModel.coursesControlModel.SubCoursesContentListAndMessageModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateFormService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateFormServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form")
public class SubCourseContentUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=null;	
		int AdminId=0;
		
		HttpSession session = request.getSession();
		
		AdminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);
		if(AdminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		//Get and set Id for identification operation.
		id=request.getParameter("id");
		request.setAttribute("id", id);
		
		SubCourseContentUpdateFormService service = new SubCourseContentUpdateFormServiceImpl();
		
		SubCoursesContentListAndMessageModel getinformationBasedOnAdminService = service.getinformationBasedOnAdminService(AdminId);
		
		if(getinformationBasedOnAdminService.getMessage_error()!=null) {
			request.setAttribute("message_error", getinformationBasedOnAdminService.getMessage_error());
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp");
			rd.forward(request, response);
			return;
		}else {
			request.setAttribute("SubCourseInfo", getinformationBasedOnAdminService.getSubCoursesInfo());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form.jsp");
			rd.forward(request, response);
			return;
		}	
	}
}